package com.github.easytag.core.converters.impl;

import com.github.easytag.core.converters.TypeConverter;
import com.github.easytag.core.dto.logic.LogicData;
import com.github.easytag.core.enums.DataTypeEnum;

public class LongTypeConverter implements TypeConverter {

    private static final LongTypeConverter instance = new LongTypeConverter();

    private LongTypeConverter() {
    }

    public static LongTypeConverter getInstance() {
        return instance;
    }

    @Override
    public LogicData convert(Object targetValue) {
        return new LogicData(targetValue, DataTypeEnum.LONG);
    }
}
