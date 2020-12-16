package me.easytag.core.factory;

import me.easytag.core.converters.TypeConverter;
import me.easytag.core.converters.impl.*;
import me.easytag.core.enums.DataTypeEnum;
import me.easytag.core.exception.DataTypeUnSupportException;

public class TypeConverterFactory {
    public static TypeConverter getConverter(DataTypeEnum targetType) {
        switch (targetType) {
            case STRING: return new StringTypeConverter();
            case INTEGER: return new IntegerTypeConverter();
            case DATE: return new DateTypeConverter();
            case LONG: return new LongTypeConverter();
            case DOUBLE: return new DoubleTypeConverter();
            default: throw new DataTypeUnSupportException("Unexpected value: " + targetType);
        }
    }
}
