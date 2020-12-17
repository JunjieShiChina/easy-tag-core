package me.easytag.core.component;

import me.easytag.core.enums.LogicalOperatorEnum;
import me.easytag.core.exception.UnSupportLogicalTypeException;
import me.easytag.core.strategy.LogicalOperatorStrategy;
import me.easytag.core.strategy.impl.logicaloperator.*;

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
