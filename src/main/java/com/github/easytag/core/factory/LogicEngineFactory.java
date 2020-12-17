package com.github.easytag.core.factory;

import com.github.easytag.core.engine.logic.LogicEngine;
import com.github.easytag.core.engine.logic.impl.DefaultLogicEngine;

public class LogicEngineFactory {
    public static LogicEngine getDefaultLogicEngine() {
        return DefaultLogicEngine.getInstance();
    }
}
