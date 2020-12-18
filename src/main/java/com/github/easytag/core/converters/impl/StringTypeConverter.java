package com.github.easytag.core.converters.impl;

import com.github.easytag.core.converters.TypeConverter;
import com.github.easytag.core.dto.logic.LogicData;
import com.github.easytag.core.enums.DataTypeEnum;

public class StringTypeConverter implements TypeConverter {

    private static final StringTypeConverter instance = new StringTypeConverter();

    private StringTypeConverter() {
    }

    public static StringTypeConverter getInstance() {
        return instance;
    }

    @Override
    public LogicData convert(Object targetValue) {
        return new LogicData(targetValue, DataTypeEnum.STRING);
    }
}
