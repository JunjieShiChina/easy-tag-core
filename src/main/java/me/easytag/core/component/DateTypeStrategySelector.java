package me.easytag.core.component;

import me.easytag.core.enums.DataTypeEnum;
import me.easytag.core.exception.DataTypeUnSupportException;
import me.easytag.core.strategy.DataTypeStrategy;
import me.easytag.core.strategy.impl.datatype.*;

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
                throw new DataTypeUnSupportException("Unexpected value: " + dataType);
        }
    }
}
