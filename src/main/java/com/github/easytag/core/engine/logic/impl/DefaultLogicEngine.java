package com.github.easytag.core.engine.logic.impl;

import com.github.easytag.core.component.LogicalOperatorStrategySelector;
import com.github.easytag.core.enums.LogicalOperatorEnum;
import com.github.easytag.core.exception.DataTypeUnMatchException;
import com.github.easytag.core.dto.logic.LogicData;
import com.github.easytag.core.engine.logic.LogicEngine;
import com.github.easytag.core.strategy.LogicalOperatorStrategy;

/**
 * 默认逻辑处理器
 */
public class DefaultLogicEngine implements LogicEngine {

    private static final DefaultLogicEngine defaultLogicEngine = new DefaultLogicEngine();

    private DefaultLogicEngine() {
    }

    public static DefaultLogicEngine getInstance() {
        return defaultLogicEngine;
    }

    @Override
    public boolean doCompare(LogicData source, LogicData target, LogicalOperatorEnum logicalOperator) {
        if(!source.getDataType().equals(target.getDataType())) {
            throw new DataTypeUnMatchException("数据类型不一致错误,源数据类型:" + source.getDataType().getDesc() + ",目标数据类型:" + target.getDataType().getDesc());
        }
        // 获取比较策略
        LogicalOperatorStrategy logicalOperatorStrategy = LogicalOperatorStrategySelector.selectStrategy(logicalOperator);
        return logicalOperatorStrategy.handle(source, target);
    }
}
