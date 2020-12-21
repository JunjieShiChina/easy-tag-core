package com.github.easytag.core.resolver.impl;

import com.github.easytag.core.dto.express.ExpressNode;
import com.github.easytag.core.enums.ExpressionMarkEnum;
import com.github.easytag.core.enums.JudgeTypeEnum;
import com.github.easytag.core.enums.LogicalOperatorEnum;
import com.github.easytag.core.exception.ExpressionSyntaxExpression;
import com.github.easytag.core.resolver.ExpressionParser;

public class DefaultExpressionParser implements ExpressionParser {

    private static final String EXPRESSION_REGEX = " ";

    @Override
    public ExpressNode parse(String expression) {
        String[] expressionStrNodes = expression.split(EXPRESSION_REGEX);

        ExpressNode headConditionNode = ExpressNode.createConditionNode();
        for (int index = 0; index < expressionStrNodes.length; ) {
            String expressionStrNode = expressionStrNodes[index];
            // itemNode
            if (LogicalOperatorEnum.notExist(expressionStrNode) && JudgeTypeEnum.notExist(expressionStrNode) && ExpressionMarkEnum.notExist(expressionStrNode)) {
                if (index + 2 > expressionStrNodes.length - 1) {
                    throw new ExpressionSyntaxExpression("错误的表达式:" + expression);
                }
                String var1 = expressionStrNode;
                String logicalOperatorStr = expressionStrNodes[index + 1];
                LogicalOperatorEnum logicalOperator = LogicalOperatorEnum.findByName(logicalOperatorStr);
                if (logicalOperator == null) {
                    throw new ExpressionSyntaxExpression("不支持的逻辑运算符:" + logicalOperatorStr);
                }
                String var2 = expressionStrNodes[index + 2];
                index = index + 3;

                // conditionNode下如果直接发现表达式细项，默认拼接AND节点
                ExpressNode andTypeNode = ExpressNode.createJudgeTypeNode(JudgeTypeEnum.AND);
                ExpressNode itemNode = ExpressNode.createItemNode(var1, logicalOperator, var2);
                andTypeNode.getChildrenNodes().add(itemNode);
                headConditionNode.getChildrenNodes().add(andTypeNode);
            }

            //judgeTypeNode
            if (JudgeTypeEnum.exist(expressionStrNode)) {
                JudgeTypeEnum judgeType = JudgeTypeEnum.findByName(expressionStrNode);
                if (judgeType == null) {
                    throw new ExpressionSyntaxExpression("不支持的连接运算符:" + expressionStrNode);
                }
                if (index + 1 > expressionStrNodes.length - 1) {
                    throw new RuntimeException();
                }

                ExpressNode judgeTypeNode = ExpressNode.createJudgeTypeNode(judgeType);
                String nextExpressionStr = expressionStrNodes[index + 1];
                int curIndex = index + 1;
                // 发现下一个节点是一个表达式
                if (nextExpressionStr.equals(ExpressionMarkEnum.LEFT_CONDITION_MARK.getDesc())) {
                    // 抽取子表达式
                    String childrenExpression = getChildrenExpression(expressionStrNodes, index + 1);
                    // 得到子表达式长度
                    Integer childrenExpressionLen = getExpressionLen(childrenExpression);
                    // 迭代解析子表达式
                    ExpressNode childrenHeadNode = parse(childrenExpression);
                    judgeTypeNode.getChildrenNodes().add(childrenHeadNode);

                    index = curIndex + childrenExpressionLen + 2;
                } else
                // 发现下一个节点itemNode
                if (LogicalOperatorEnum.notExist(nextExpressionStr) && JudgeTypeEnum.notExist(nextExpressionStr) && ExpressionMarkEnum.notExist(nextExpressionStr)) {
                    if (curIndex + 2 > expressionStrNodes.length - 1) {
                        throw new ExpressionSyntaxExpression("错误的表达式:" + expression);
                    }
                    String var1 = nextExpressionStr;
                    String logicalOperatorStr = expressionStrNodes[curIndex + 1];
                    LogicalOperatorEnum logicalOperator = LogicalOperatorEnum.findByName(logicalOperatorStr);
                    if (logicalOperator == null) {
                        throw new ExpressionSyntaxExpression("不支持的逻辑运算符:" + logicalOperatorStr);
                    }
                    String var2 = expressionStrNodes[curIndex + 2];
                    index = curIndex + 3;

                    // conditionNode下如果直接发现表达式细项，默认拼接AND节点
                    ExpressNode itemNode = ExpressNode.createItemNode(var1, logicalOperator, var2);
                    judgeTypeNode.getChildrenNodes().add(itemNode);
                } else {
                    // judgeType的下一个节点只能是子表达式或者细项
                    throw new ExpressionSyntaxExpression("错误的表达式:" + expression);
                }

                headConditionNode.getChildrenNodes().add(judgeTypeNode);
            }

            // 发现是一个表达式
            if (expressionStrNode.equals(ExpressionMarkEnum.LEFT_CONDITION_MARK.getDesc())) {
                // 默认拼接AND节点
                ExpressNode andTypeNode = ExpressNode.createJudgeTypeNode(JudgeTypeEnum.AND);

                // 抽取子表达式
                String childrenExpression = getChildrenExpression(expressionStrNodes, index);
                // 得到子表达式长度
                Integer childrenExpressionLen = getExpressionLen(childrenExpression);
                // 迭代解析子表达式
                ExpressNode childrenHeadNode = parse(childrenExpression);
                andTypeNode.getChildrenNodes().add(childrenHeadNode);

                headConditionNode.getChildrenNodes().add(andTypeNode);

                index = index + childrenExpressionLen + 2;
            }
        }
        return headConditionNode;
    }

    private Integer getExpressionLen(String childrenExpression) {
        return childrenExpression.split(EXPRESSION_REGEX).length;
    }

    private String getChildrenExpression(String[] expressionStrNodes, int fromIndex) {
        StringBuilder sb = new StringBuilder();
        int leftMarkCnt = 0;
        for (int index = fromIndex; index < expressionStrNodes.length; index++) {
            sb.append(expressionStrNodes[index]).append(EXPRESSION_REGEX);
            if(ExpressionMarkEnum.LEFT_CONDITION_MARK.getDesc().equals(expressionStrNodes[index])) {
                leftMarkCnt ++;
            }
            if(ExpressionMarkEnum.RIGHT_CONDITION_MARK.getDesc().equals(expressionStrNodes[index])) {
                if(leftMarkCnt == 1) {
                    break;
                }
                leftMarkCnt --;
            }
        }
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.lastIndexOf(ExpressionMarkEnum.RIGHT_CONDITION_MARK.getDesc()));
        return sb.toString().trim();
    }
}
