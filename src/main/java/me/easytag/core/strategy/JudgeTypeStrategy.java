package me.easytag.core.strategy;

import me.easytag.core.dto.comparator.CompareData;

import java.util.List;

public interface JudgeTypeStrategy {
    boolean doJudge(List<CompareData> compareDataList);
}
