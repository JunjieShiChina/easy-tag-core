package me.easytag.core.factory;

import me.easytag.core.engine.logic.LogicEngine;
import me.easytag.core.engine.logic.impl.DefaultLogicEngine;

public class LogicEngineFactory {
    public static LogicEngine getDefaultLogicEngine() {
        return DefaultLogicEngine.getInstance();
    }
}
