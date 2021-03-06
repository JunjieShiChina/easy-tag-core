package com.github.easytag.core.strategy;

import com.github.easytag.core.dto.logic.LogicData;

/**
 * 逻辑比较策略
 */
public interface LogicalOperatorStrategy {
    /**
     * 执行策略
     * @param source
     * @param target
     * @return
     */
    boolean handle(LogicData source, LogicData target);
}
