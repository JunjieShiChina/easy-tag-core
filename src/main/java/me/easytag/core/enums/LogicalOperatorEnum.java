package me.easytag.core.enums;

/**
 * 逻辑运算符枚举
 */
public enum  LogicalOperatorEnum {
    EQUALS(0, "EQUALS"),
    NOT_EQUALS(1, "NOT_EQUALS"),
    GREATER(2, "GREATER"),
    LESS(3, "LESS"),
    IN(4, "IN"),
    NOT_IN(5, "NOT IN"),
    BETWEEN(6, "BETWEEN"),
    NOT_BETWEEN(7, "NOT_BETWEEN")
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
