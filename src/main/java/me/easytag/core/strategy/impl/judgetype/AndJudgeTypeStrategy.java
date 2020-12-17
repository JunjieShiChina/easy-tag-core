package me.easytag.core.strategy.impl.judgetype;

import me.easytag.core.driver.comparator.ComparatorDriver;
import me.easytag.core.driver.comparator.impl.DefaultComparatorDriver;
import me.easytag.core.dto.comparator.CompareData;
import me.easytag.core.strategy.JudgeTypeStrategy;

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
