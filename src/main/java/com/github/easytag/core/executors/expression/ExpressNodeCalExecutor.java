package com.github.easytag.core.executors.expression;

import com.github.easytag.core.dto.express.ExpressNode;
import com.github.easytag.core.dto.logic.LogicData;

import java.util.Map;

/**
 * 表达式节点计算器
 */
public interface ExpressNodeCalExecutor {
    boolean execute(ExpressNode headNode, Map<String, LogicData> variables);
}
