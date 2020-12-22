package com.github.easytag.core.executors.expression.impl;

import com.github.easytag.core.dto.express.ExpressNode;
import com.github.easytag.core.dto.express.ExpressionContext;
import com.github.easytag.core.dto.logic.LogicData;
import com.github.easytag.core.executors.expression.ExpressNodeCalExecutor;
import com.github.easytag.core.executors.expression.ExpressionExecutor;
import com.github.easytag.core.resolver.ExpressionParser;
import com.github.easytag.core.resolver.impl.DefaultExpressionParser;

import java.util.Map;

public class DefaultExpressionExecutor implements ExpressionExecutor {

    private static final DefaultExpressionExecutor defaultExpressionExecutor = new DefaultExpressionExecutor();

    // 表达式转换器
    private ExpressionParser expressionParser = DefaultExpressionParser.getInstance();

    // 表达式节点计算器
    private ExpressNodeCalExecutor expressNodeCalExecutor = DefaultExpressNodeCalExecutor.getInstance();

    private DefaultExpressionExecutor() {
    }

    public static ExpressionExecutor getInstance() {
        return defaultExpressionExecutor;
    }

    @Override
    public boolean execute(ExpressionContext context) {
        Map<String, LogicData> variables = context.getVariables();
        String expression = context.getExpression();
        ExpressNode headNode = expressionParser.parse(expression);
        return doExecutor(headNode, variables);
    }

    // 执行计算
    private boolean doExecutor(ExpressNode headNode, Map<String, LogicData> variables) {
        return expressNodeCalExecutor.execute(headNode, variables);
    }
}
