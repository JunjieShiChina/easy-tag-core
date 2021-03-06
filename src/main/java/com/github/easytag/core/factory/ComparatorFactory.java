package com.github.easytag.core.factory;

import com.github.easytag.core.comparators.Comparator;
import com.github.easytag.core.comparators.impl.*;
import com.github.easytag.core.enums.DataTypeEnum;
import com.github.easytag.core.enums.LogicalOperatorEnum;
import com.github.easytag.core.exception.UnSupportLogicalTypeException;

public class ComparatorFactory {
    public static Comparator getComparator(LogicalOperatorEnum logicalOperator, DataTypeEnum dataType) {
        switch (logicalOperator) {
            case EQUALS: return new EqualsComparator(dataType);
            case NOT_EQUALS: return new NotEqualsComparator(dataType);
            case LESS: return new LessComparator(dataType);
            case GREATER: return new GreaterComparator(dataType);
            case IN: return new InComparator(dataType);
            case NOT_IN: return new NotInComparator(dataType);
            case BETWEEN: return new BetweenComparator(dataType);
            case NOT_BETWEEN: return new NotBetweenComparator(dataType);
            default: throw new UnSupportLogicalTypeException("不支持的逻辑运算类型:" + logicalOperator);
        }
    }
}
