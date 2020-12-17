package me.easytag.core.strategy.impl.datatype;

import me.easytag.core.dto.logic.LogicData;
import me.easytag.core.strategy.DataTypeStrategy;

/**
 * Long类型策略
 */
public class LongTypeStrategy implements DataTypeStrategy {
    @Override
    public boolean handleEquals(LogicData source, LogicData target) {
        Long sourceLong = (Long) source.getValue();
        Long targetLong = (Long) target.getValue();
        if(sourceLong == null || targetLong == null) {
            return false;
        }
        return sourceLong.equals(targetLong);
    }

    @Override
    public boolean handleLess(LogicData source, LogicData target) {
        Long sourceLong = (Long) source.getValue();
        Long targetLong = (Long) target.getValue();
        if(sourceLong == null || targetLong == null) {
            return false;
        }
        return sourceLong < targetLong;
    }

    @Override
    public boolean handleGreater(LogicData source, LogicData target) {
        Long sourceLong = (Long) source.getValue();
        Long targetLong = (Long) target.getValue();
        if(sourceLong == null || targetLong == null) {
            return false;
        }
        return sourceLong > targetLong;
    }

    @Override
    public boolean handleIn(LogicData source, LogicData target) {
        Long sourceLong = (Long) source.getValue();
        Long[] targetLongArray = (Long[]) target.getValue();
        if(sourceLong == null || targetLongArray == null || targetLongArray.length < 1) {
            return false;
        }
        for (Long targetLong: targetLongArray) {
            if(targetLong.equals(sourceLong)) {
                return true;
            }
        }
        return  false;
    }

    @Override
    public boolean handleBetween(LogicData source, LogicData target) {
        Long sourceLong = (Long) source.getValue();
        Long[] targetLongArray = (Long[]) target.getValue();
        if(sourceLong == null || targetLongArray == null || targetLongArray.length < 2) {
            return false;
        }
        Long targetLongFrom = null;
        Long targetLongTo = null;

        Long targetLong1 = targetLongArray[0];
        Long targetLong2 = targetLongArray[1];
        if(targetLong1 < targetLong2) {
            targetLongFrom = targetLong1;
            targetLongTo = targetLong2;
        } else {
            targetLongFrom = targetLong2;
            targetLongTo = targetLong1;
        }

        if(sourceLong.equals(targetLongFrom) || sourceLong.equals(targetLongTo)) {
            return true;
        }

        return sourceLong > targetLongFrom && sourceLong < targetLongTo;
    }
}
