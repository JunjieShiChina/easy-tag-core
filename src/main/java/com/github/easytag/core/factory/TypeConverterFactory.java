package com.github.easytag.core.factory;

import com.github.easytag.core.converters.TypeConverter;
import com.github.easytag.core.converters.impl.*;
import com.github.easytag.core.exception.UnSupportDataTypeException;
import com.github.easytag.core.enums.DataTypeEnum;

public class TypeConverterFactory {
    public static TypeConverter getConverter(DataTypeEnum targetType) {
        switch (targetType) {
            case STRING: return new StringTypeConverter();
            case INTEGER: return new IntegerTypeConverter();
            case DATE: return new DateTypeConverter();
            case LONG: return new LongTypeConverter();
            case DOUBLE: return new DoubleTypeConverter();
            default: throw new UnSupportDataTypeException("Unexpected value: " + targetType);
        }
    }
}
