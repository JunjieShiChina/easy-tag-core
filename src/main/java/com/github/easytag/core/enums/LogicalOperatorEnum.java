package com.github.easytag.core.enums;

import sun.rmi.runtime.Log;

/**
 * 逻辑运算符枚举
 */
public enum LogicalOperatorEnum {
    EQUALS(0, "EQUALS"),
    NOT_EQUALS(1, "NOT_EQUALS"),
    GREATER(2, "GREATER"),
    LESS(3, "LESS"),
    IN(4, "IN"),
    NOT_IN(5, "NOT_IN"),
    BETWEEN(6, "BETWEEN"),
    NOT_BETWEEN(7, "NOT_BETWEEN");
    private Integer code;
    private String value;

    LogicalOperatorEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static boolean exist(String value) {
        LogicalOperatorEnum[] logicalOperatorEnums = LogicalOperatorEnum.values();
        for (LogicalOperatorEnum logicalOperatorEnum : logicalOperatorEnums) {
            if (value.equals(logicalOperatorEnum.getValue())) {
                return true;
            }
        }
        return false;
    }

    public static boolean notExist(String value) {
        return !exist(value);
    }

    public static LogicalOperatorEnum findByName(String name) {
        LogicalOperatorEnum[] logicalOperatorEnums = LogicalOperatorEnum.values();
        for (LogicalOperatorEnum logicalOperatorEnum : logicalOperatorEnums) {
            if(logicalOperatorEnum.name().equals(name)) {
                return logicalOperatorEnum;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
