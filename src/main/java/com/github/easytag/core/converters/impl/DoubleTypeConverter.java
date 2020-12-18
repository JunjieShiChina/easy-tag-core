package com.github.easytag.core.converters.impl;

import com.github.easytag.core.converters.TypeConverter;
import com.github.easytag.core.dto.logic.LogicData;
import com.github.easytag.core.enums.DataTypeEnum;

public class DoubleTypeConverter implements TypeConverter {

    private static final DoubleTypeConverter instance = new DoubleTypeConverter();

    private DoubleTypeConverter() {
    }

    public static DoubleTypeConverter getInstance() {
        return instance;
    }

    @Override
    public LogicData convert(Object targetValue) {
        return new LogicData(targetValue, DataTypeEnum.DOUBLE);
    }
}
