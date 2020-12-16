package me.easytag.core.logic.dto.engine.logic;

import me.easytag.core.enums.LogicalOperatorEnum;
import me.easytag.core.logic.dto.LogicData;

public interface LogicEngine {

    boolean doCompare(LogicData source, LogicData target, LogicalOperatorEnum logicalOperator);

}
