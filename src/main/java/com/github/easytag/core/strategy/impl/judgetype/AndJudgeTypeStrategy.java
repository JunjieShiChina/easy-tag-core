package com.github.easytag.core.strategy.impl.judgetype;

import com.github.easytag.core.driver.comparator.ComparatorDriver;
import com.github.easytag.core.driver.comparator.impl.DefaultComparatorDriver;
import com.github.easytag.core.dto.comparator.CompareData;
import com.github.easytag.core.strategy.JudgeTypeStrategy;

import java.util.List;

/**
 * AND策略
 */
public class AndJudgeTypeStrategy implements JudgeTypeStrategy {
    private ComparatorDriver comparatorDriver = DefaultComparatorDriver.getInstance();

    @Override
    public boolean doJudge(List<CompareData> compareDataList) {
        return !comparatorDriver.hasFalse(compareDataList);
    }
}
