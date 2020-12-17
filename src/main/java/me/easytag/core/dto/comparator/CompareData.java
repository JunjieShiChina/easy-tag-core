package me.easytag.core.dto.comparator;

import me.easytag.core.enums.DataTypeEnum;
import me.easytag.core.enums.LogicalOperatorEnum;

import java.io.Serializable;

public class CompareData implements Serializable {
    private Object sourceData;
    private Object targetData;
    private LogicalOperatorEnum logicalOperator;
    private DataTypeEnum dataType;

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

    public LogicalOperatorEnum getLogicalOperator() {
        return logicalOperator;
    }

    public void setLogicalOperator(LogicalOperatorEnum logicalOperator) {
        this.logicalOperator = logicalOperator;
    }

    public DataTypeEnum getDataType() {
        return dataType;
    }

    public void setDataType(DataTypeEnum dataType) {
        this.dataType = dataType;
    }
}
