package com.github.easytag.core.strategy;

import com.github.easytag.core.dto.logic.LogicData;

public interface DataTypeStrategy {
    boolean handleEquals(LogicData source, LogicData target);

    boolean handleLess(LogicData source, LogicData target);

    boolean handleGreater(LogicData source, LogicData target);

    boolean handleIn(LogicData source, LogicData target);

    boolean handleBetween(LogicData source, LogicData target);
}
