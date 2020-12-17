package com.github.easytag.core.converters;

import com.github.easytag.core.dto.logic.LogicData;

/**
 * 类型转换器
 */
public interface TypeConverter {

    /**
     * 转换数据类型
     * @param targetValue
     * @return
     */
    LogicData convert(Object targetValue);
}
