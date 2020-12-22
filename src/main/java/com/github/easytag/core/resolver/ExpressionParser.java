package com.github.easytag.core.resolver;

import com.github.easytag.core.dto.express.ExpressCondition;
import com.github.easytag.core.dto.express.ExpressNode;
import com.github.easytag.core.dto.express.ExpressionContext;

public interface ExpressionParser {

    /**
     * 表达式转换成树
     * @param expression
     * @return
     */
    ExpressNode parse(String expression);

    /**
     * dto转换成表达式(变量提取)
     * @return
     */
    ExpressionContext parseExpression(ExpressCondition expressCondition);

}
