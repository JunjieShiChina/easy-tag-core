package com.github.easytag.core.dto.express;

import com.github.easytag.core.dto.logic.LogicData;
import com.github.easytag.core.enums.JudgeTypeEnum;
import com.github.easytag.core.enums.LogicalOperatorEnum;
import com.github.easytag.core.enums.NodeTypeEnum;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 表达式节点
 */
public class ExpressNode implements Serializable {

    /**
     * 节点类型
     */
    private NodeTypeEnum nodeType;
    /**
     * 连接类型
     */
    private JudgeTypeEnum judgeType;
    /**
     * 变量1
     */
    private String var1;
    /**
     * 变量2
     */
    private String var2;
    /**
     * 逻辑运算符
     */
    private LogicalOperatorEnum logicalOperator;
    /**
     * 子节点
     */
    private Queue<ExpressNode> childrenNodes;

    /**
     * 创建表达式头节点
     * @return
     */
    public static ExpressNode createConditionNode() {
        ExpressNode expressNode = new ExpressNode();
        expressNode.setNodeType(NodeTypeEnum.CONDITION);
        expressNode.setChildrenNodes(new LinkedList<>());
        return expressNode;
    }

    /**
     * 创建表达式基础项节点
     * @param var1
     * @param logicalOperator
     * @param var2
     * @return
     */
    public static ExpressNode createItemNode(String var1, LogicalOperatorEnum logicalOperator, String var2) {
        ExpressNode expressNode = new ExpressNode();
        expressNode.setNodeType(NodeTypeEnum.EXPRESS_ITEM);
        expressNode.setVar1(var1);
        expressNode.setLogicalOperator(logicalOperator);
        expressNode.setVar2(var2);
        return expressNode;
    }

    public static ExpressNode createJudgeTypeNode(JudgeTypeEnum judgeType) {
        ExpressNode expressNode = new ExpressNode();
        expressNode.setNodeType(NodeTypeEnum.JUDGE_TYPE);
        expressNode.setJudgeType(judgeType);
        expressNode.setChildrenNodes(new LinkedList<>());
        return expressNode;
    }

    public NodeTypeEnum getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeTypeEnum nodeType) {
        this.nodeType = nodeType;
    }

    public JudgeTypeEnum getJudgeType() {
        return judgeType;
    }

    public void setJudgeType(JudgeTypeEnum judgeType) {
        this.judgeType = judgeType;
    }

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }

    public LogicalOperatorEnum getLogicalOperator() {
        return logicalOperator;
    }

    public void setLogicalOperator(LogicalOperatorEnum logicalOperator) {
        this.logicalOperator = logicalOperator;
    }

    public Queue<ExpressNode> getChildrenNodes() {
        return childrenNodes;
    }

    public void setChildrenNodes(Queue<ExpressNode> childrenNodes) {
        this.childrenNodes = childrenNodes;
    }
}
