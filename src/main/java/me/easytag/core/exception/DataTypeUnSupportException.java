package me.easytag.core.exception;

/**
 * 数据类型不匹配异常
 */
public class DataTypeUnSupportException extends RuntimeException {
    public DataTypeUnSupportException(String message) {
        super(message);
    }
}
