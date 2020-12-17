package me.easytag.core.driver.judgetype.impl;

import me.easytag.core.driver.judgetype.JudgeTypeDriver;
import me.easytag.core.dto.comparator.CompareData;
import me.easytag.core.dto.judge.JudgeData;
import me.easytag.core.engine.judgetype.JudgeTypeEngine;
import me.easytag.core.engine.judgetype.impl.DefaultJudgeTypeEngine;
import me.easytag.core.enums.JudgeTypeEnum;
import me.easytag.core.exception.JudgeTypeExecuteException;

import java.util.List;

public class DefaultJudgeTypeDriver implements JudgeTypeDriver {

    public static final DefaultJudgeTypeDriver defaultJudgeTypeDriver = new DefaultJudgeTypeDriver();

    private DefaultJudgeTypeDriver() {
    }

    public static JudgeTypeDriver getInstance() {
        return defaultJudgeTypeDriver;
    }

    @Override
    public boolean execute(JudgeData judgeData) {
        List<CompareData> compareDataList = judgeData.getCompareDataList();
        if(compareDataList == null || compareDataList.size() < 1) {
            throw new JudgeTypeExecuteException("compareDataList list cant not be empty");
        }
        JudgeTypeEnum judgeType = judgeData.getJudgeType();
        if(judgeType == null) {
            throw new JudgeTypeExecuteException("judgeType cant not be empty");
        }

        JudgeTypeEngine judgeTypeEngine = DefaultJudgeTypeEngine.getInstance();
        return judgeTypeEngine.doJudge(judgeType, compareDataList);
    }

}
