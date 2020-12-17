package com.github.easytag.core.strategy.impl.datatype;

import com.github.easytag.core.dto.logic.LogicData;
import com.github.easytag.core.strategy.DataTypeStrategy;

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

    @Override
    public boolean handleBetween(LogicData source, LogicData target) {
        Double sourceDouble = (Double) source.getValue();
        Double[] targetDoubleArray = (Double[]) target.getValue();
        if(sourceDouble == null || targetDoubleArray == null || targetDoubleArray.length < 2) {
            return false;
        }
        Double targetDoubleFrom = null;
        Double targetDoubleTo = null;

        Double targetDouble1 = targetDoubleArray[0];
        Double targetDouble2 = targetDoubleArray[1];
        if(targetDouble1 < targetDouble2) {
            targetDoubleFrom = targetDouble1;
            targetDoubleTo = targetDouble2;
        } else {
            targetDoubleFrom = targetDouble2;
            targetDoubleTo = targetDouble1;
        }

        if(sourceDouble.equals(targetDoubleFrom) || sourceDouble.equals(targetDoubleTo)) {
            return true;
        }

        return sourceDouble > targetDoubleFrom && sourceDouble < targetDoubleTo;
    }
}
