package me.easytag.core.driver.comparator.impl;

import me.easytag.core.comparators.Comparator;
import me.easytag.core.driver.comparator.ComparatorDriver;
import me.easytag.core.dto.comparator.CompareData;
import me.easytag.core.enums.DataTypeEnum;
import me.easytag.core.enums.LogicalOperatorEnum;
import me.easytag.core.factory.ComparatorFactory;

import java.util.List;

public class DefaultComparatorDriver implements ComparatorDriver {

    private static final DefaultComparatorDriver defaultComparatorDriver = new DefaultComparatorDriver();

    private DefaultComparatorDriver() {
    }

    public static ComparatorDriver getInstance() {
        return defaultComparatorDriver;
    }

    @Override
    public boolean execute(Object sourceData, Object targetData, LogicalOperatorEnum logicalOperator, DataTypeEnum dataType) {
        Comparator comparator = ComparatorFactory.getComparator(logicalOperator, dataType);
        return comparator.compare(sourceData, targetData);
    }

    @Override
    public boolean hasFalse(List<CompareData> compareDataList) {
        for (CompareData compareData : compareDataList) {
            if(!execute(compareData.getSourceData(), compareData.getTargetData(), compareData.getLogicalOperator(), compareData.getDataType())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasTrue(List<CompareData> compareDataList) {
        for (CompareData compareData : compareDataList) {
            if(execute(compareData.getSourceData(), compareData.getTargetData(), compareData.getLogicalOperator(), compareData.getDataType())) {
                return true;
            }
        }
        return false;
    }

}
