package com.github.easytag.core.component;

import com.github.easytag.core.dto.logic.LogicData;

import java.util.Map;

public class VarNameGenerator {
    // 生成变量名称
    public static String generateVarName(Map<String, LogicData> variables) {
        int size = variables.size();
        return "var_" + size;
    }
}
