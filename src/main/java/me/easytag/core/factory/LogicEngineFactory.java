package me.easytag.core.factory;

import me.easytag.core.logic.dto.engine.logic.LogicEngine;
import me.easytag.core.logic.dto.engine.logic.impl.DefaultLogicEngine;

public class LogicEngineFactory {
    public static LogicEngine getDefaultLogicEngine() {
        return DefaultLogicEngine.getInstance();
    }
}
