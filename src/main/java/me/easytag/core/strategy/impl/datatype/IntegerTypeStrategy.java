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
        return sourceInt.equals(targetInt);
    }

    @Override
    public boolean handleLess(LogicData source, LogicData target) {
        Integer sourceInt = (Integer) source.getValue();
        Integer targetInt = (Integer) target.getValue();
        return sourceInt < targetInt;
    }

    @Override
    public boolean handleGreater(LogicData source, LogicData target) {
        Integer sourceInt = (Integer) source.getValue();
        Integer targetInt = (Integer) target.getValue();
        return sourceInt > targetInt;
    }

}
