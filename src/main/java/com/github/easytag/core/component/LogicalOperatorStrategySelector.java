package com.github.easytag.core.component;

import com.github.easytag.core.enums.LogicalOperatorEnum;
import com.github.easytag.core.strategy.LogicalOperatorStrategy;
import com.github.easytag.core.strategy.impl.logicaloperator.*;
import com.github.easytag.core.exception.UnSupportLogicalTypeException;

/**
 * 逻辑比较策略选择器
 */
public class LogicalOperatorStrategySelector {

    /**
     * 根据逻辑类型选择策略
     * @param logicalOperator 逻辑比较类型
     * @return
     */
    public static LogicalOperatorStrategy selectStrategy(LogicalOperatorEnum logicalOperator) {
        switch(logicalOperator) {
            case EQUALS: return new EqualsOperatorStrategy();
            case LESS: return new LessOperatorStrategy();
            case GREATER: return new GreaterOperatorStrategy();
            case IN: return new InOperatorStrategy();
            case BETWEEN: return new BetweenOperatorStrategy();
            default: throw new UnSupportLogicalTypeException("不支持的逻辑运算类型:" + logicalOperator);
        }
    }
}
