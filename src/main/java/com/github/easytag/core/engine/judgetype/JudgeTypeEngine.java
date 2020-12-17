package com.github.easytag.core.engine.judgetype;

import com.github.easytag.core.dto.comparator.CompareData;
import com.github.easytag.core.enums.JudgeTypeEnum;

import java.util.List;

/**
 * 组合判断引擎
 */
public interface JudgeTypeEngine {

    boolean doJudge(JudgeTypeEnum judgeType, List<CompareData> compareDataList);

}
