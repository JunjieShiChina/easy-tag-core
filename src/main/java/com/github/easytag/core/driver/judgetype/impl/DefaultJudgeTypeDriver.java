package com.github.easytag.core.driver.judgetype.impl;

import com.github.easytag.core.engine.judgetype.JudgeTypeEngine;
import com.github.easytag.core.engine.judgetype.impl.DefaultJudgeTypeEngine;
import com.github.easytag.core.driver.judgetype.JudgeTypeDriver;
import com.github.easytag.core.dto.comparator.CompareData;
import com.github.easytag.core.dto.judge.JudgeData;
import com.github.easytag.core.enums.JudgeTypeEnum;
import com.github.easytag.core.exception.JudgeTypeExecuteException;

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
