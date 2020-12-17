package me.easytag.core.converters.impl;

import me.easytag.core.converters.TypeConverter;
import me.easytag.core.enums.DataTypeEnum;
import me.easytag.core.dto.logic.LogicData;

public class LongTypeConverter implements TypeConverter {
    @Override
    public LogicData convert(Object targetValue) {
        return new LogicData(targetValue, DataTypeEnum.LONG);
    }
}
