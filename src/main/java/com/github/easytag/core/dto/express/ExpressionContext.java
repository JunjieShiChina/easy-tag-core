package com.github.easytag.core.dto.express;

import com.github.easytag.core.dto.logic.LogicData;

import java.io.Serializable;
import java.util.Map;

/**
 * 表达式上下文
 */
public class ExpressionContext implements Serializable {

    // 转换得到的表达式
    private String expression;
    // 变量集合
    private Map<String, LogicData> variables;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public Map<String, LogicData> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, LogicData> variables) {
        this.variables = variables;
    }
}
