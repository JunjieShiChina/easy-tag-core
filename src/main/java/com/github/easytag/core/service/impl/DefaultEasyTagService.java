package com.github.easytag.core.service.impl;

import com.github.easytag.core.dto.express.ExpressCondition;
import com.github.easytag.core.dto.express.ExpressionContext;
import com.github.easytag.core.executors.expression.ExpressionExecutor;
import com.github.easytag.core.executors.expression.impl.DefaultExpressionExecutor;
import com.github.easytag.core.resolver.impl.DefaultExpressionParser;
import com.github.easytag.core.service.EasyTagService;

public class DefaultEasyTagService implements EasyTagService {

    private static final DefaultEasyTagService defaultEasyTagService = new DefaultEasyTagService();

    private DefaultExpressionParser defaultExpressionParser = DefaultExpressionParser.getInstance();
    private ExpressionExecutor expressionExecutor = DefaultExpressionExecutor.getInstance();

    private DefaultEasyTagService() {
    }

    public static DefaultEasyTagService getInstance() {
        return defaultEasyTagService;
    }

    @Override
    public boolean handle(ExpressCondition expressCondition) {
        ExpressionContext expressionContext = defaultExpressionParser.parseExpression(expressCondition);
        return expressionExecutor.execute(expressionContext);
    }
}
