package com.github.easytag.core.component;

import java.util.Map;

public class VarNameGenerator {
    // 生成变量名称
    public static String generateVarName(Map<String, Object> variables) {
        int size = variables.size();
        return "var_" + size;
    }
}
