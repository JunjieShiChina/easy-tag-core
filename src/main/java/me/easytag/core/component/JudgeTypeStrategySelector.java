package me.easytag.core.component;

import me.easytag.core.enums.JudgeTypeEnum;
import me.easytag.core.exception.UnSupportJudgeTypeException;
import me.easytag.core.strategy.JudgeTypeStrategy;
import me.easytag.core.strategy.impl.judgetype.AndJudgeTypeStrategy;
import me.easytag.core.strategy.impl.judgetype.OrJudgeTypeStrategy;

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
