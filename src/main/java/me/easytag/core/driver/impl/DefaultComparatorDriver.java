package me.easytag.core.driver.impl;

import me.easytag.core.comparators.Comparator;
import me.easytag.core.driver.ComparatorDriver;
import me.easytag.core.enums.DataTypeEnum;
import me.easytag.core.enums.LogicalOperatorEnum;
import me.easytag.core.factory.ComparatorFactory;

public class DefaultComparatorDriver implements ComparatorDriver {

    @Override
    public boolean execute(Object sourceData, Object targetData, LogicalOperatorEnum logicalOperator, DataTypeEnum dataType) {
        Comparator comparator = ComparatorFactory.getComparator(logicalOperator, dataType);
        return comparator.compare(sourceData, targetData);
    }

}
