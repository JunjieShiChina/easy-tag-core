package com.github.easytag.core.dto.express;

import java.io.Serializable;

public class ExpressItem implements Serializable {
    // 逻辑运算符
    private String logicalOperator;
    private Object sourceData;
    private Object targetData;
    // 数据类型
    private String dataType;

    public String getLogicalOperator() {
        return logicalOperator;
    }

    public void setLogicalOperator(String logicalOperator) {
        this.logicalOperator = logicalOperator;
    }

    public Object getSourceData() {
        return sourceData;
    }

    public void setSourceData(Object sourceData) {
        this.sourceData = sourceData;
    }

    public Object getTargetData() {
        return targetData;
    }

    public void setTargetData(Object targetData) {
        this.targetData = targetData;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
