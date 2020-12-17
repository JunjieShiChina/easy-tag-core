package me.easytag.core.comparators.impl;

import me.easytag.core.comparators.Comparator;
import me.easytag.core.converters.TypeConverter;
import me.easytag.core.enums.DataTypeEnum;
import me.easytag.core.factory.TypeConverterFactory;
import me.easytag.core.dto.logic.LogicData;

/**
 * 相等比较器
 */
public class EqualsComparator implements Comparator {
    /**
     * 目标数据类型
     */
    private DataTypeEnum targetTypeEnum;

    public EqualsComparator(DataTypeEnum targetTypeEnum) {
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
        return logicDataSource.equals(logicDataTarget);
    }

}
