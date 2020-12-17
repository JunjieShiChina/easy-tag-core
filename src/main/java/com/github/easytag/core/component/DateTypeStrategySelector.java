package com.github.easytag.core.component;

import com.github.easytag.core.enums.DataTypeEnum;
import com.github.easytag.core.exception.UnSupportDataTypeException;
import com.github.easytag.core.strategy.DataTypeStrategy;
import com.github.easytag.core.strategy.impl.datatype.*;

/**
 * 数据类型策略选择器
 */
public class DateTypeStrategySelector {
    public static DataTypeStrategy selectStrategy(DataTypeEnum dataType) {
        switch (dataType) {
            case STRING: return new StringTypeStrategy();
            case INTEGER: return new IntegerTypeStrategy();
            case DOUBLE: return new DoubleTypeStrategy();
            case LONG: return new LongTypeStrategy();
            case DATE: return new DateTypeStrategy();
            default:
                throw new UnSupportDataTypeException("Unexpected value: " + dataType);
        }
    }
}
