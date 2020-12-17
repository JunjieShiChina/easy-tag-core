package com.github.easytag.core.strategy;

import com.github.easytag.core.dto.comparator.CompareData;

import java.util.List;

public interface JudgeTypeStrategy {
    boolean doJudge(List<CompareData> compareDataList);
}
