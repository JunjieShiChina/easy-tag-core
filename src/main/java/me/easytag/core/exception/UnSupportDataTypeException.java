package me.easytag.core.exception;

/**
 * 数据类型不匹配异常
 */
public class UnSupportDataTypeException extends RuntimeException {
    public UnSupportDataTypeException(String message) {
        super(message);
    }
}
