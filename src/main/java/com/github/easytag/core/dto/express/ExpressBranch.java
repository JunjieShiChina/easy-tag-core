package com.github.easytag.core.dto.express;

import java.io.Serializable;

public class ExpressBranch implements Serializable {
    private String judgeType = "AND";
    private ExpressItem expressItem;
    private ExpressCondition expressCondition;

    public String getJudgeType() {
        return judgeType;
    }

    public void setJudgeType(String judgeType) {
        this.judgeType = judgeType;
    }

    public ExpressItem getExpressItem() {
        return expressItem;
    }

    public void setExpressItem(ExpressItem expressItem) {
        this.expressItem = expressItem;
    }

    public ExpressCondition getExpressCondition() {
        return expressCondition;
    }

    public void setExpressCondition(ExpressCondition expressCondition) {
        this.expressCondition = expressCondition;
    }
}
