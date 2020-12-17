package me.easytag.core.strategy.impl.datatype;

import me.easytag.core.exception.UnSupportHandleTypeException;
import me.easytag.core.dto.logic.LogicData;
import me.easytag.core.strategy.DataTypeStrategy;

/**
 * 字符串类型策略
 */
public class StringTypeStrategy implements DataTypeStrategy {
    @Override
    public boolean handleEquals(LogicData source, LogicData target) {
        String sourceStr = (String) source.getValue();
        String targetStr = (String) target.getValue();
        if(sourceStr == null || targetStr == null) {
            return false;
        }
        return sourceStr.equals(targetStr);
    }

    @Override
    public boolean handleLess(LogicData source, LogicData target) {
        throw new UnSupportHandleTypeException("字符串不支持比较大小");
    }

    @Override
    public boolean handleGreater(LogicData source, LogicData target) {
        throw new UnSupportHandleTypeException("字符串不支持比较大小");
    }

    @Override
    public boolean handleIn(LogicData source, LogicData target) {
        String sourceStr = (String) source.getValue();
        String[] targetStrArrays = (String[]) target.getValue();
        if(sourceStr == null || targetStrArrays == null || targetStrArrays.length < 1) {
            return false;
        }
        for (String targetStr: targetStrArrays) {
            if(sourceStr.equals(targetStr)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean handleBetween(LogicData source, LogicData target) {
        throw new UnSupportHandleTypeException("字符串不支持Between");
    }

}
