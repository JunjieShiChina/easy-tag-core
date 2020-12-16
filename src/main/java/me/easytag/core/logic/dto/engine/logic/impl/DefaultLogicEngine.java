package me.easytag.core.logic.dto.engine.logic.impl;

import me.easytag.core.enums.DataTypeEnum;
import me.easytag.core.exception.DataTypeUnMatchException;
import me.easytag.core.exception.DataTypeUnSupportException;
import me.easytag.core.logic.dto.LogicData;
import me.easytag.core.logic.dto.engine.logic.LogicEngine;

import java.util.Date;

/**
 * 默认逻辑处理器
 */
public class DefaultLogicEngine implements LogicEngine {

    private static final DefaultLogicEngine defaultLogicEngine = new DefaultLogicEngine();

    private DefaultLogicEngine() {
    }

    public static DefaultLogicEngine getInstance() {
        return defaultLogicEngine;
    }

    @Override
    public boolean doCompare(LogicData source, LogicData target) {
        if(!source.getDataType().equals(target.getDataType())) {
            throw new DataTypeUnMatchException("数据类型不一致错误,源数据类型:" + source.getDataType().getDesc() + ",目标数据类型:" + target.getDataType().getDesc());
        }
        DataTypeEnum dataType = source.getDataType();
        switch (dataType) {
            case STRING: return doStringEquals(source, target);
            case INTEGER: return doIntegerEquals(source, target);
            case DOUBLE: return doDoubleEquals(source, target);
            case LONG: return doLongEquals(source, target);
            case DATE: return doDateEquals(source, target);
            default:
                throw new DataTypeUnSupportException("Unexpected value: " + dataType);
        }
    }

    private boolean doDateEquals(LogicData source, LogicData target) {
        Date sourceDate = (Date) source.getValue();
        Date targetDate = (Date) target.getValue();
        return sourceDate.equals(targetDate);
    }

    private boolean doLongEquals(LogicData source, LogicData target) {
        Long sourceLong = (Long) source.getValue();
        Long targetLong = (Long) target.getValue();
        return sourceLong.equals(targetLong);
    }

    private boolean doDoubleEquals(LogicData source, LogicData target) {
        Double sourceDouble = (Double) source.getValue();
        Double targetDouble = (Double) target.getValue();
        return sourceDouble.equals(targetDouble);
    }

    private boolean doIntegerEquals(LogicData source, LogicData target) {
        Integer sourceInt = (Integer) source.getValue();
        Integer targetInt = (Integer) target.getValue();
        return sourceInt.equals(targetInt);
    }

    private boolean doStringEquals(LogicData source, LogicData target) {
        String sourceStr = (String) source.getValue();
        String targetStr = (String) target.getValue();
        return sourceStr.equals(targetStr);
    }


}
