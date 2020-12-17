package com.github.easytag.core.enums;

/**
 * 条件连接逻辑
 */
public enum JudgeTypeEnum {
    AND(0, "AND"),
    OR(1, "OR")
    ;
    private Integer code;
    private String desc;

    JudgeTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
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
