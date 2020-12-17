package com.github.easytag.core.strategy.impl.judgetype;

import com.github.easytag.core.dto.comparator.CompareData;
import com.github.easytag.core.strategy.JudgeTypeStrategy;
import com.github.easytag.core.driver.comparator.ComparatorDriver;
import com.github.easytag.core.driver.comparator.impl.DefaultComparatorDriver;

import java.util.List;

/**
 * OR策略
 */
public class OrJudgeTypeStrategy implements JudgeTypeStrategy {

    private ComparatorDriver comparatorDriver = DefaultComparatorDriver.getInstance();

    @Override
    public boolean doJudge(List<CompareData> compareDataList) {
        return comparatorDriver.hasTrue(compareDataList);
    }
}
