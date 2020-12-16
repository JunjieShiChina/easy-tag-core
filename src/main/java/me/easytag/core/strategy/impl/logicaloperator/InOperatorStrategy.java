package me.easytag.core.strategy.impl.logicaloperator;

import me.easytag.core.component.DateTypeStrategySelector;
import me.easytag.core.logic.dto.LogicData;
import me.easytag.core.strategy.DataTypeStrategy;
import me.easytag.core.strategy.LogicalOperatorStrategy;

public class InOperatorStrategy implements LogicalOperatorStrategy {

    @Override
    public boolean handle(LogicData source, LogicData target) {
        DataTypeStrategy dataTypeStrategy = DateTypeStrategySelector.selectStrategy(source.getDataType());
        return dataTypeStrategy.handleIn(source, target);
    }

}
