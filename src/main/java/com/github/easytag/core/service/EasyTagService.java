package com.github.easytag.core.service;

import com.github.easytag.core.dto.express.ExpressCondition;

public interface EasyTagService {
    boolean handle(ExpressCondition expressCondition);
}
