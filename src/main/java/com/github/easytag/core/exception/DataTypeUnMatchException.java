package com.github.easytag.core.exception;

/**
 * 数据类型不匹配异常
 */
public class DataTypeUnMatchException extends RuntimeException {
    public DataTypeUnMatchException(String message) {
        super(message);
    }
}
