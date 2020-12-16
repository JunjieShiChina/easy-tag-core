package me.easytag.core.strategy;

import me.easytag.core.logic.dto.LogicData;

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
