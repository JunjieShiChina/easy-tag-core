package com.github.easytag.core.dto.judge;

import com.github.easytag.core.dto.comparator.CompareData;
import com.github.easytag.core.enums.JudgeTypeEnum;

import java.io.Serializable;
import java.util.List;

public class JudgeData implements Serializable {

    private JudgeTypeEnum judgeType;
    private List<CompareData> compareDataList;

    public JudgeTypeEnum getJudgeType() {
        return judgeType;
    }

    public void setJudgeType(JudgeTypeEnum judgeType) {
        this.judgeType = judgeType;
    }

    public List<CompareData> getCompareDataList() {
        return compareDataList;
    }

    public void setCompareDataList(List<CompareData> compareDataList) {
        this.compareDataList = compareDataList;
    }
}
