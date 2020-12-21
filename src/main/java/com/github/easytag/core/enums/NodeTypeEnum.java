package com.github.easytag.core.enums;

/**
 * 节点类型
 * CONDITION : 表达式
 * JUDGE_TYPE : 逻辑连接（AND,OR）
 * EXPRESS_ITEM : 表达式子项
 */
public enum NodeTypeEnum {
    CONDITION,JUDGE_TYPE,EXPRESS_ITEM;

    /**
     * 判断节点是子项
     * @param expressionStrNode
     * @return
     */
    public static boolean isExpressItem(String expressionStrNode) {
        return LogicalOperatorEnum.notExist(expressionStrNode) && JudgeTypeEnum.notExist(expressionStrNode) && ExpressionMarkEnum.notExist(expressionStrNode);
    }

    /**
     * 判断节点是逻辑连接（AND,OR）
     * @param expressionStrNode
     * @return
     */
    public static boolean isJudgeType(String expressionStrNode) {
        return JudgeTypeEnum.exist(expressionStrNode);
    }

    /**
     * 判断节点是表达式
     * @param nextExpressionStr
     * @return
     */
    public static boolean isCondition(String nextExpressionStr) {
        return nextExpressionStr.equals(ExpressionMarkEnum.LEFT_CONDITION_MARK.getDesc());
    }
}
