package com.github.easytag.core.executors.expression.impl;

import com.github.easytag.core.driver.comparator.ComparatorDriver;
import com.github.easytag.core.driver.comparator.impl.DefaultComparatorDriver;
import com.github.easytag.core.dto.express.ExpressNode;
import com.github.easytag.core.dto.logic.LogicData;
import com.github.easytag.core.enums.JudgeTypeEnum;
import com.github.easytag.core.enums.NodeTypeEnum;
import com.github.easytag.core.executors.expression.ExpressNodeCalExecutor;

import java.util.Map;
import java.util.Queue;

public class DefaultExpressNodeCalExecutor implements ExpressNodeCalExecutor {

    private static final DefaultExpressNodeCalExecutor defaultExpressNodeCalExecutor = new DefaultExpressNodeCalExecutor();

    private static final ComparatorDriver comparatorDriver = DefaultComparatorDriver.getInstance();

    private DefaultExpressNodeCalExecutor() {
    }

    public static ExpressNodeCalExecutor getInstance() {
        return defaultExpressNodeCalExecutor;
    }

    @Override
    public boolean execute(ExpressNode headNode, Map<String, LogicData> variables) {
        NodeTypeEnum nodeType = headNode.getNodeType();
        if (nodeType.equals(NodeTypeEnum.CONDITION)) {
            return handleConditionNode(headNode, variables);
        } else if (nodeType.equals(NodeTypeEnum.JUDGE_TYPE)) {
            Queue<ExpressNode> childrenNodes = headNode.getChildrenNodes();
            if(!childrenNodes.isEmpty()) {
                return execute(childrenNodes.poll(), variables);
            }
            return true;
        } else if (nodeType.equals(NodeTypeEnum.EXPRESS_ITEM)) {
            String var1 = headNode.getVar1();
            String var2 = headNode.getVar2();
            LogicData logicData1 = variables.get(var1);
            LogicData logicData2 = variables.get(var2);
            return comparatorDriver.execute(logicData1.getValue(), logicData2.getValue(), headNode.getLogicalOperator(), logicData1.getDataType());
        } else {
            return false;
        }
    }

    /**
     * 处理表达式node
     * @param headNode
     * @param variables
     * @return
     */
    private boolean handleConditionNode(ExpressNode headNode, Map<String, LogicData> variables) {
        Queue<ExpressNode> childrenNodes = headNode.getChildrenNodes();
        // 下一个节点的连接符（默认and）
        JudgeTypeEnum nextJudgeType = JudgeTypeEnum.AND;
        while(!childrenNodes.isEmpty()) {
            ExpressNode curExpressNode = childrenNodes.poll();
            ExpressNode nextExpressNode = null;
            if(!childrenNodes.isEmpty()) {
                nextExpressNode = childrenNodes.peek();
                nextJudgeType = nextExpressNode.getJudgeType();
            }
            if(nextJudgeType.equals(JudgeTypeEnum.AND)) {
                // 如果下一个节点连接符为AND,则当前节点必须为true,否在直接返回false
                if(!execute(curExpressNode, variables)) {
                    return false;
                }
            }
            if(nextJudgeType.equals(JudgeTypeEnum.OR)) {
                // 如果下一个节点连接符为OR,如果当前节点如果为true,则跳过下一个节点判断。否则再判断下一个节点
                if(execute(curExpressNode, variables)) {
                    // 跳过下一个节点
                    childrenNodes.poll();
                } else {
                    // 判断下一个节点
                    if(!execute(childrenNodes.poll(), variables)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


}
