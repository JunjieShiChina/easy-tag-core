package me.easytag.core.strategy.impl.datatype;

import me.easytag.core.logic.dto.LogicData;
import me.easytag.core.strategy.DataTypeStrategy;

/**
 * DOUBLE类型策略
 */
public class DoubleTypeStrategy implements DataTypeStrategy {
    @Override
    public boolean handleEquals(LogicData source, LogicData target) {
        Double sourceDouble = (Double) source.getValue();
        Double targetDouble = (Double) target.getValue();
        if(sourceDouble == null || targetDouble == null) {
            return false;
        }
        return sourceDouble.equals(targetDouble);
    }

    @Override
    public boolean handleLess(LogicData source, LogicData target) {
        Double sourceDouble = (Double) source.getValue();
        Double targetDouble = (Double) target.getValue();
        if(sourceDouble == null || targetDouble == null) {
            return false;
        }
        return sourceDouble < targetDouble;
    }

    @Override
    public boolean handleGreater(LogicData source, LogicData target) {
        Double sourceDouble = (Double) source.getValue();
        Double targetDouble = (Double) target.getValue();
        if(sourceDouble == null || targetDouble == null) {
            return false;
        }
        return sourceDouble > targetDouble;
    }

    @Override
    public boolean handleIn(LogicData source, LogicData target) {
        Double sourceDouble = (Double) source.getValue();
        Double[] targetDoubleArray = (Double[]) target.getValue();
        if(sourceDouble == null || targetDoubleArray == null || targetDoubleArray.length < 1) {
            return false;
        }
        for (Double targetDouble: targetDoubleArray) {
            if(targetDouble.equals(sourceDouble)) {
                return true;
            }
        }
        return  false;
    }
}
