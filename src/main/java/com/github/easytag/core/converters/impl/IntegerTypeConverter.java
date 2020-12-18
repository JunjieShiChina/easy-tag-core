package com.github.easytag.core.converters.impl;

import com.github.easytag.core.converters.TypeConverter;
import com.github.easytag.core.dto.logic.LogicData;
import com.github.easytag.core.enums.DataTypeEnum;

public class IntegerTypeConverter implements TypeConverter {

    private static final IntegerTypeConverter instance = new IntegerTypeConverter();

    private IntegerTypeConverter() {
    }

    public static IntegerTypeConverter getInstance() {
        return instance;
    }

    @Override
    public LogicData convert(Object targetValue) {
        return new LogicData(targetValue, DataTypeEnum.INTEGER);
    }
}
