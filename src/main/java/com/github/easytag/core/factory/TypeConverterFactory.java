package com.github.easytag.core.factory;

import com.github.easytag.core.converters.TypeConverter;
import com.github.easytag.core.converters.impl.*;
import com.github.easytag.core.exception.UnSupportDataTypeException;
import com.github.easytag.core.enums.DataTypeEnum;

public class TypeConverterFactory {
    public static TypeConverter getConverter(DataTypeEnum targetType) {
        switch (targetType) {
            case STRING: return StringTypeConverter.getInstance();
            case INTEGER: return IntegerTypeConverter.getInstance();
            case DATE: return DateTypeConverter.getInstance();
            case LONG: return LongTypeConverter.getInstance();
            case DOUBLE: return DoubleTypeConverter.getInstance();
            default: throw new UnSupportDataTypeException("Unexpected value: " + targetType);
        }
    }
}
