package com.github.easytag.core.executors.expression;

import com.github.easytag.core.dto.express.ExpressionContext;

/**
 * 表达式处理器
 */
public interface ExpressionExecutor {

    /**
     * 执行表达式
     * @param context
     * @return
     */
    boolean execute(ExpressionContext context);

}
