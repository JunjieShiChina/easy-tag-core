package com.github.easytag.core.strategy.impl.logicaloperator;

import com.github.easytag.core.component.DateTypeStrategySelector;
import com.github.easytag.core.dto.logic.LogicData;
import com.github.easytag.core.strategy.DataTypeStrategy;
import com.github.easytag.core.strategy.LogicalOperatorStrategy;

public class EqualsOperatorStrategy implements LogicalOperatorStrategy {

    @Override
    public boolean handle(LogicData source, LogicData target) {
        DataTypeStrategy dataTypeStrategy = DateTypeStrategySelector.selectStrategy(source.getDataType());
        return dataTypeStrategy.handleEquals(source, target);
    }

}
