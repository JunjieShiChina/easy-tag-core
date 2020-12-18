package com.github.easytag.core.converters.impl;

import com.github.easytag.core.converters.TypeConverter;
import com.github.easytag.core.dto.logic.LogicData;
import com.github.easytag.core.enums.DataTypeEnum;

public class DateTypeConverter implements TypeConverter {

    private static final DateTypeConverter instance = new DateTypeConverter();

    private DateTypeConverter() {
    }

    public static DateTypeConverter getInstance() {
        return instance;
    }

    @Override
    public LogicData convert(Object targetValue) {
        return new LogicData(targetValue, DataTypeEnum.DATE);
    }
}
