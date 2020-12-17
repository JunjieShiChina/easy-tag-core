package me.easytag.core.exception;

/**
 * 数据类型不匹配异常
 */
public class UnSupportLogicalTypeException extends RuntimeException {
    public UnSupportLogicalTypeException(String message) {
        super(message);
    }
}
