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

    public static boolean exist(String value) {
        JudgeTypeEnum[] judgeTypeEnums = JudgeTypeEnum.values();
        for (JudgeTypeEnum judgeTypeEnum : judgeTypeEnums) {
            if(value.equals(judgeTypeEnum.getDesc())) {
                return true;
            }
        }
        return false;
    }

    public static boolean notExist(String value) {
        return !exist(value);
    }

    public static JudgeTypeEnum findByName(String name) {
        JudgeTypeEnum[] judgeTypeEnums = JudgeTypeEnum.values();
        for (JudgeTypeEnum judgeTypeEnum : judgeTypeEnums) {
            if(judgeTypeEnum.name().equals(name)) {
                return judgeTypeEnum;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
