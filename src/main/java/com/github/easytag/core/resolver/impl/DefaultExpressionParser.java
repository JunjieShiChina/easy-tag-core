package com.github.easytag.core.resolver.impl;

import com.github.easytag.core.component.VarNameGenerator;
import com.github.easytag.core.converters.TypeConverter;
import com.github.easytag.core.dto.express.*;
import com.github.easytag.core.dto.logic.LogicData;
import com.github.easytag.core.enums.*;
import com.github.easytag.core.exception.ExpressRevertException;
import com.github.easytag.core.exception.ExpressionSyntaxExpression;
import com.github.easytag.core.exception.UnSupportDataTypeException;
import com.github.easytag.core.factory.TypeConverterFactory;
import com.github.easytag.core.resolver.ExpressionParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultExpressionParser implements ExpressionParser {

    private static final DefaultExpressionParser defaultExpressionParser = new DefaultExpressionParser();

    private static final String EXPRESSION_REGEX = " ";

    private DefaultExpressionParser() {
    }

    public static DefaultExpressionParser getInstance() {
        return defaultExpressionParser;
    }

    @Override
    public ExpressNode parse(String expression) {
        if(expression == null) {
            throw new ExpressionSyntaxExpression("表达式不能为空");
        }

        return doParse(expression);
    }

    @Override
    public ExpressionContext parseExpression(ExpressCondition expressCondition) {
        return doParseExpression(expressCondition);
    }

    private ExpressionContext doParseExpression(ExpressCondition expressCondition) {
        ExpressionContext expressionContext = new ExpressionContext();
        // 变量抽取
        Map<String, LogicData> variables = new HashMap<>();
        String expression = revertExpress(expressCondition, variables);
        expressionContext.setVariables(variables);
        expressionContext.setExpression(expression);
        return expressionContext;
    }

    private String revertExpress(ExpressCondition expressCondition, Map<String, LogicData> variables) {
        StringBuffer expression = new StringBuffer();
        List<ExpressBranch> expressBranches = expressCondition.getExpressBranches();
        for (ExpressBranch expressBranch : expressBranches) {
            String judgeType = expressBranch.getJudgeType();
            ExpressItem expressItem = expressBranch.getExpressItem();
            ExpressCondition childrenCondition = expressBranch.getExpressCondition();
            if(expressItem != null) {
                expression.append(EXPRESSION_REGEX).append(judgeType).append(EXPRESSION_REGEX).append(revertItem(expressItem, variables));
            } else if(childrenCondition != null) {
                expression.append(EXPRESSION_REGEX).append(judgeType).append(EXPRESSION_REGEX).append(revertCondition(childrenCondition, variables));
            } else {
                throw new ExpressRevertException("生成表达式异常,连接符后面不能为空");
            }
        }

        return expression.toString().trim();
    }

    private String revertCondition(ExpressCondition childrenCondition, Map<String, LogicData> variables) {
        StringBuffer conditionExpress = new StringBuffer();
        conditionExpress.append(ExpressionMarkEnum.LEFT_CONDITION_MARK.getDesc()).append(EXPRESSION_REGEX);

        List<ExpressBranch> expressBranches = childrenCondition.getExpressBranches();
        for (ExpressBranch expressBranch : expressBranches) {
            conditionExpress.append(expressBranch.getJudgeType()).append(EXPRESSION_REGEX);
            if(expressBranch.getExpressItem() != null) {
                conditionExpress.append(revertItem(expressBranch.getExpressItem(), variables));
            } else if(expressBranch.getExpressCondition() != null) {
                conditionExpress.append(revertCondition(expressBranch.getExpressCondition(), variables));
            } else {
                throw new ExpressRevertException("生成表达式异常,连接符后面不能为空");
            }
        }

        conditionExpress.append(EXPRESSION_REGEX).append(ExpressionMarkEnum.RIGHT_CONDITION_MARK.getDesc());
        return conditionExpress.toString().trim();
    }

    private String revertItem(ExpressItem expressItem, Map<String, LogicData> variables) {
        StringBuffer itemExpress = new StringBuffer();

        String dataType = expressItem.getDataType();
        DataTypeEnum dataTypeEnum = DataTypeEnum.findByName(dataType);
        if(dataTypeEnum == null) {
            throw new UnSupportDataTypeException("不支持的数据类型");
        }
        TypeConverter converter = TypeConverterFactory.getConverter(dataTypeEnum);
        LogicData logicDataSource = converter.convert(expressItem.getSourceData());
        LogicData logicDataTarget = converter.convert(expressItem.getTargetData());
        // 生成变量名
        String varNameSource = VarNameGenerator.generateVarName(variables);
        variables.put(varNameSource, logicDataSource);
        String varNameTarget = VarNameGenerator.generateVarName(variables);
        variables.put(varNameTarget, logicDataTarget);

        itemExpress.append(varNameSource).append(EXPRESSION_REGEX).append(expressItem.getLogicalOperator()).append(EXPRESSION_REGEX).append(varNameTarget);
        return itemExpress.toString().trim();
    }

    private ExpressNode doParse(String expression) {
        String[] expressionStrNodes = expression.split(EXPRESSION_REGEX);
        ExpressNode headConditionNode = ExpressNode.createConditionNode();
        for (int index = 0; index < expressionStrNodes.length; ) {
            String expressionStrNode = expressionStrNodes[index];
            // itemNode
            if (NodeTypeEnum.isExpressItem(expressionStrNode)) {
//                if (index + 2 > expressionStrNodes.length - 1) {
                if (index > expressionStrNodes.length - 3) {
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
            if (NodeTypeEnum.isJudgeType(expressionStrNode)) {
                JudgeTypeEnum judgeType = JudgeTypeEnum.findByName(expressionStrNode);
                if (judgeType == null) {
                    throw new ExpressionSyntaxExpression("不支持的连接运算符:" + expressionStrNode);
                }
//                if (index + 1 > expressionStrNodes.length - 1) {
                if (index > expressionStrNodes.length - 2) {
                    throw new RuntimeException();
                }

                ExpressNode judgeTypeNode = ExpressNode.createJudgeTypeNode(judgeType);
                String nextExpressionStr = expressionStrNodes[index + 1];
                int curIndex = index + 1;
                // 发现下一个节点是一个表达式
                if (NodeTypeEnum.isCondition(nextExpressionStr)) {
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
                    if (NodeTypeEnum.isExpressItem(nextExpressionStr)) {
//                        if (curIndex + 2 > expressionStrNodes.length - 1) {
                        if (curIndex > expressionStrNodes.length - 3) {
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
            } else
            // 发现是一个表达式
            if (NodeTypeEnum.isCondition(expressionStrNode)) {
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
            else
            {
                throw new ExpressionSyntaxExpression("错误的表达式:" + expression);
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
