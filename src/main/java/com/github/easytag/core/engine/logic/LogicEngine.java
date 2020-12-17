package com.github.easytag.core.engine.logic;

import com.github.easytag.core.dto.logic.LogicData;
import com.github.easytag.core.enums.LogicalOperatorEnum;

/**
 * 数据比较引擎
 */
public interface LogicEngine {

    boolean doCompare(LogicData source, LogicData target, LogicalOperatorEnum logicalOperator);

}
