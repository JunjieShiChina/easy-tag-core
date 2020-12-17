package com.github.easytag.core.dto.logic;

import com.github.easytag.core.engine.logic.LogicEngine;
import com.github.easytag.core.factory.LogicEngineFactory;
import com.github.easytag.core.enums.DataTypeEnum;
import com.github.easytag.core.enums.LogicalOperatorEnum;

/**
 * 逻辑数据
 */
public class LogicData {
    private Object value;
    private DataTypeEnum dataType;

    public LogicData(Object value, DataTypeEnum dataType) {
        this.value = value;
        this.dataType = dataType;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public DataTypeEnum getDataType() {
        return dataType;
    }

    public void setDataType(DataTypeEnum dataType) {
        this.dataType = dataType;
    }

    public boolean equals(LogicData target) {
        LogicEngine logicEngine = LogicEngineFactory.getDefaultLogicEngine();
        return logicEngine.doCompare(this, target, LogicalOperatorEnum.EQUALS);
    }

    public boolean less(LogicData target) {
        LogicEngine logicEngine = LogicEngineFactory.getDefaultLogicEngine();
        return logicEngine.doCompare(this, target, LogicalOperatorEnum.LESS);
    }

    public boolean greater(LogicData target) {
        LogicEngine logicEngine = LogicEngineFactory.getDefaultLogicEngine();
        return logicEngine.doCompare(this, target, LogicalOperatorEnum.GREATER);
    }

    public boolean in(LogicData target) {
        LogicEngine logicEngine = LogicEngineFactory.getDefaultLogicEngine();
        return logicEngine.doCompare(this, target, LogicalOperatorEnum.IN);
    }

    public boolean between(LogicData target) {
        LogicEngine logicEngine = LogicEngineFactory.getDefaultLogicEngine();
        return logicEngine.doCompare(this, target, LogicalOperatorEnum.BETWEEN);
    }
}
