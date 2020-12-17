package me.easytag.core.engine.judgetype;

import me.easytag.core.dto.comparator.CompareData;
import me.easytag.core.enums.JudgeTypeEnum;

import java.util.List;

/**
 * 组合判断引擎
 */
public interface JudgeTypeEngine {

    boolean doJudge(JudgeTypeEnum judgeType, List<CompareData> compareDataList);

}
