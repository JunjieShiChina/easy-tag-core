package me.easytag.core.factory;

import me.easytag.core.comparators.Comparator;
import me.easytag.core.comparators.impl.EqualsComparator;
import me.easytag.core.comparators.impl.GreaterComparator;
import me.easytag.core.comparators.impl.InComparator;
import me.easytag.core.comparators.impl.LessComparator;
import me.easytag.core.enums.DataTypeEnum;
import me.easytag.core.enums.LogicalOperatorEnum;
import me.easytag.core.exception.LogicalTypeUnSupportException;

public class ComparatorFactory {
    public static Comparator getComparator(LogicalOperatorEnum logicalOperator, DataTypeEnum dataType) {
        switch (logicalOperator) {
            case EQUALS: return new EqualsComparator(dataType);
            case LESS: return new LessComparator(dataType);
            case GREATER: return new GreaterComparator(dataType);
            case IN: return new InComparator(dataType);
            default: throw new LogicalTypeUnSupportException("不支持的逻辑运算类型:" + logicalOperator);
        }
    }
}
