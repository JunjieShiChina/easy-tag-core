package me.easytag.core.strategy.impl.datatype;

import me.easytag.core.logic.dto.LogicData;
import me.easytag.core.strategy.DataTypeStrategy;

/**
 * INTEGER类型策略
 */
public class IntegerTypeStrategy implements DataTypeStrategy {

    @Override
    public boolean handleEquals(LogicData source, LogicData target) {
        Integer sourceInt = (Integer) source.getValue();
        Integer targetInt = (Integer) target.getValue();
        if(sourceInt == null || targetInt == null) {
            return false;
        }
        return sourceInt.equals(targetInt);
    }

    @Override
    public boolean handleLess(LogicData source, LogicData target) {
        Integer sourceInt = (Integer) source.getValue();
        Integer targetInt = (Integer) target.getValue();
        if(sourceInt == null || targetInt == null) {
            return false;
        }
        return sourceInt < targetInt;
    }

    @Override
    public boolean handleGreater(LogicData source, LogicData target) {
        Integer sourceInt = (Integer) source.getValue();
        Integer targetInt = (Integer) target.getValue();
        if(sourceInt == null || targetInt == null) {
            return false;
        }
        return sourceInt > targetInt;
    }

    @Override
    public boolean handleIn(LogicData source, LogicData target) {
        Integer sourceInt = (Integer) source.getValue();
        Integer[] targetIntArray = (Integer[]) target.getValue();
        if(sourceInt == null || targetIntArray == null || targetIntArray.length < 1) {
            return false;
        }
        for (Integer targetInt: targetIntArray) {
            if(targetInt.equals(sourceInt)) {
                return true;
            }
        }
        return  false;
    }

    @Override
    public boolean handleBetween(LogicData source, LogicData target) {
        Integer sourceInt = (Integer) source.getValue();
        Integer[] targetIntArray = (Integer[]) target.getValue();
        if(sourceInt == null || targetIntArray == null || targetIntArray.length < 2) {
            return false;
        }
        Integer targetIntegerFrom = null;
        Integer targetIntegerTo = null;

        Integer targetInteger1 = targetIntArray[0];
        Integer targetInteger2 = targetIntArray[1];
        if(targetInteger1 < targetInteger2) {
            targetIntegerFrom = targetInteger1;
            targetIntegerTo = targetInteger2;
        } else {
            targetIntegerFrom = targetInteger2;
            targetIntegerTo = targetInteger1;
        }

        if(sourceInt.equals(targetIntegerFrom) || sourceInt.equals(targetIntegerTo)) {
            return true;
        }

        return sourceInt > targetIntegerFrom && sourceInt < targetIntegerTo;
    }

}
