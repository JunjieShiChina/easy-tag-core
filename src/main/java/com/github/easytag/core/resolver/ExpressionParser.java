package com.github.easytag.core.resolver;

import com.github.easytag.core.dto.express.ExpressNode;

public interface ExpressionParser {

    ExpressNode parse(String expression);

}
