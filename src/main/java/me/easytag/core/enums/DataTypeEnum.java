package me.easytag.core.enums;

/**
 * 数据类型美军
 */
public enum DataTypeEnum {
    STRING(0, "STRING"),
    INTEGER(1, "INTEGER"),
    DOUBLE(2, "DOUBLE"),
    DATE(3, "DATE"),
    LONG(4, "LONG");
    private Integer code;
    private String desc;

    DataTypeEnum(Integer code, String desc) {
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
