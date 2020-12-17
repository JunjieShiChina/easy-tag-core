package com.github.easytag.core.comparators.impl;

import com.github.easytag.core.comparators.Comparator;
import com.github.easytag.core.converters.TypeConverter;
import com.github.easytag.core.dto.logic.LogicData;
import com.github.easytag.core.enums.DataTypeEnum;
import com.github.easytag.core.factory.TypeConverterFactory;

/**
 * 大于比较器
 */
public class GreaterComparator implements Comparator {
    /**
     * 目标数据类型
     */
    private DataTypeEnum targetTypeEnum;

    public GreaterComparator(DataTypeEnum targetTypeEnum) {
        this.targetTypeEnum = targetTypeEnum;
    }

    @Override
    public boolean compare(Object source, Object target) {
        // 获取类型转换器
        TypeConverter typeConverter = TypeConverterFactory.getConverter(targetTypeEnum);
        // 转换数据类型
        LogicData logicDataSource = typeConverter.convert(source);
        LogicData logicDataTarget = typeConverter.convert(target);
        // 进行比较
        return logicDataSource.greater(logicDataTarget);
    }

}
