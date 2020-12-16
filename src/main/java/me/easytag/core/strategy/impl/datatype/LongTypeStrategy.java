package me.easytag.core.strategy.impl.datatype;

import me.easytag.core.logic.dto.LogicData;
import me.easytag.core.strategy.DataTypeStrategy;

/**
 * Long类型策略
 */
public class LongTypeStrategy implements DataTypeStrategy {
    @Override
    public boolean handleEquals(LogicData source, LogicData target) {
        Long sourceLong = (Long) source.getValue();
        Long targetLong = (Long) target.getValue();
        return sourceLong.equals(targetLong);
    }

    @Override
    public boolean handleLess(LogicData source, LogicData target) {
        Long sourceLong = (Long) source.getValue();
        Long targetLong = (Long) target.getValue();
        return sourceLong < targetLong;
    }

    @Override
    public boolean handleGreater(LogicData source, LogicData target) {
        Long sourceLong = (Long) source.getValue();
        Long targetLong = (Long) target.getValue();
        return sourceLong > targetLong;
    }
}
