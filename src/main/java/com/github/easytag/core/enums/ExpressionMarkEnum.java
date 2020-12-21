package com.github.easytag.core.enums;

/**
 * 表达式中的特殊字符
 */
public enum ExpressionMarkEnum {
    LEFT_CONDITION_MARK(0, "["),
    RIGHT_CONDITION_MARK(1, "]");
    private Integer code;
    private String desc;

    ExpressionMarkEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static boolean exist(String value) {
        ExpressionMarkEnum[] expressionMarkEnums = ExpressionMarkEnum.values();
        for (ExpressionMarkEnum expressionMarkEnum : expressionMarkEnums) {
            if(value.equals(expressionMarkEnum.desc)) {
                return true;
            }
        }
        return false;
    }

    public static boolean notExist(String value) {
        return !exist(value);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
