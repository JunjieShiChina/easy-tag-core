package me.easytag.core.logic.dto.engine.logic.impl;

import me.easytag.core.component.LogicalOperatorStrategySelector;
import me.easytag.core.enums.DataTypeEnum;
import me.easytag.core.enums.LogicalOperatorEnum;
import me.easytag.core.exception.DataTypeUnMatchException;
import me.easytag.core.exception.DataTypeUnSupportException;
import me.easytag.core.logic.dto.LogicData;
import me.easytag.core.logic.dto.engine.logic.LogicEngine;
import me.easytag.core.strategy.LogicalOperatorStrategy;

import java.util.Date;

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
