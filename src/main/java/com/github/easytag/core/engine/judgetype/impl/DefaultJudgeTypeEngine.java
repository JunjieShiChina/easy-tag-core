package com.github.easytag.core.engine.judgetype.impl;

import com.github.easytag.core.engine.judgetype.JudgeTypeEngine;
import com.github.easytag.core.component.JudgeTypeStrategySelector;
import com.github.easytag.core.dto.comparator.CompareData;
import com.github.easytag.core.enums.JudgeTypeEnum;
import com.github.easytag.core.strategy.JudgeTypeStrategy;

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
