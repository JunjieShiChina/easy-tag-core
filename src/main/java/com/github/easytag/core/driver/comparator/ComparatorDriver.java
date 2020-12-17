package com.github.easytag.core.driver.comparator;

import com.github.easytag.core.dto.comparator.CompareData;
import com.github.easytag.core.enums.DataTypeEnum;
import com.github.easytag.core.enums.LogicalOperatorEnum;

import java.util.List;

/**
 * 比较器驱动
 */
public interface ComparatorDriver {

    boolean execute(Object sourceData, Object targetData, LogicalOperatorEnum logicalOperator, DataTypeEnum dataType);

    boolean hasFalse(List<CompareData> compareDataList);

    boolean hasTrue(List<CompareData> compareDataList);
}
