package me.easytag.core.driver;

import me.easytag.core.enums.DataTypeEnum;
import me.easytag.core.enums.LogicalOperatorEnum;

/**
 * 比较器驱动
 */
public interface ComparatorDriver {

    boolean execute(Object sourceData, Object targetData, LogicalOperatorEnum logicalOperator, DataTypeEnum dataType);

}
