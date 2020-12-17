package me.easytag.core.engine.logic;

import me.easytag.core.dto.logic.LogicData;
import me.easytag.core.enums.LogicalOperatorEnum;

/**
 * 数据比较引擎
 */
public interface LogicEngine {

    boolean doCompare(LogicData source, LogicData target, LogicalOperatorEnum logicalOperator);

}
