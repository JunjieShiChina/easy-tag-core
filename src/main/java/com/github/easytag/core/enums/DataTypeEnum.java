package com.github.easytag.core.enums;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    public static DataTypeEnum findByName(String dataType) {
        DataTypeEnum[] dataTypeEnums = DataTypeEnum.values();
        for (DataTypeEnum dataTypeEnum : dataTypeEnums) {
            if(dataTypeEnum.name().equals(dataType)) {
                return dataTypeEnum;
            }
        }
        return null;
    }

    public static DataTypeEnum findByCode(Integer code) {
        DataTypeEnum[] dataTypeEnums = DataTypeEnum.values();
        for (DataTypeEnum dataTypeEnum : dataTypeEnums) {
            if(dataTypeEnum.getCode().equals(code)) {
                return dataTypeEnum;
            }
        }
        return null;
    }

    /**
     * 值转换
     * @param value 被转换的值
     * @return 转换后的值
     */
    public Object convertValue(String value, String pattern) {
        DateFormat format = new SimpleDateFormat(pattern);
        switch (this) {
            case STRING: return value;
            case INTEGER: return Integer.parseInt(value);
            case DOUBLE: return Double.parseDouble(value);
            case LONG: return Long.valueOf(value);
            case DATE:
                try {
                    return format.parse(value);
                } catch (ParseException e) {
                    throw new RuntimeException("日期转换错误");
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
