package me.easytag.core.logic.dto;

import me.easytag.core.enums.DataTypeEnum;
import me.easytag.core.factory.LogicEngineFactory;
import me.easytag.core.logic.dto.engine.logic.LogicEngine;

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
        return logicEngine.doCompare(this, target);
    }
}
