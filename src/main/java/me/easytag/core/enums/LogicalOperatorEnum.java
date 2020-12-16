package me.easytag.core.enums;

/**
 * 逻辑运算符枚举
 */
public enum  LogicalOperatorEnum {
    EQUALS(0, "="),
    GREATER(1, ">"),
    LESS(2, "<"),
    IN(3, "IN"),
    NOT_IN(4, "NOT IN")
    ;
    private Integer code;
    private String value;

    LogicalOperatorEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
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
