package me.easytag.core.strategy;

import me.easytag.core.dto.logic.LogicData;

public interface DataTypeStrategy {
    boolean handleEquals(LogicData source, LogicData target);

    boolean handleLess(LogicData source, LogicData target);

    boolean handleGreater(LogicData source, LogicData target);

    boolean handleIn(LogicData source, LogicData target);

    boolean handleBetween(LogicData source, LogicData target);
}
