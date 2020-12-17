package com.github.easytag.core.component;

import com.github.easytag.core.exception.UnSupportJudgeTypeException;
import com.github.easytag.core.strategy.JudgeTypeStrategy;
import com.github.easytag.core.strategy.impl.judgetype.AndJudgeTypeStrategy;
import com.github.easytag.core.strategy.impl.judgetype.OrJudgeTypeStrategy;
import com.github.easytag.core.enums.JudgeTypeEnum;

/**
 * 组合判断策略选择器
 */
public class JudgeTypeStrategySelector {
    public static JudgeTypeStrategy selectStrategy(JudgeTypeEnum judgeType) {
        switch (judgeType) {
            case AND: return new AndJudgeTypeStrategy();
            case OR: return new OrJudgeTypeStrategy();
            default: throw new UnSupportJudgeTypeException("Unexpected value: " + judgeType);
        }
    }
}
