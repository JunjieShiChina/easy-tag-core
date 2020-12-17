package me.easytag.core.engine.judgetype.impl;

import me.easytag.core.component.JudgeTypeStrategySelector;
import me.easytag.core.dto.comparator.CompareData;
import me.easytag.core.engine.judgetype.JudgeTypeEngine;
import me.easytag.core.enums.JudgeTypeEnum;
import me.easytag.core.strategy.JudgeTypeStrategy;

import java.util.List;

/**
 * 默认组合判断引擎
 */
public class DefaultJudgeTypeEngine implements JudgeTypeEngine {
    private static final DefaultJudgeTypeEngine defaultJudgeTypeEngine = new DefaultJudgeTypeEngine();

    private DefaultJudgeTypeEngine() {
    }

    public static JudgeTypeEngine getInstance() {
        return defaultJudgeTypeEngine;
    }

    @Override
    public boolean doJudge(JudgeTypeEnum judgeType, List<CompareData> compareDataList) {
        JudgeTypeStrategy judgeTypeStrategy = JudgeTypeStrategySelector.selectStrategy(judgeType);
        return judgeTypeStrategy.doJudge(compareDataList);
    }
}
