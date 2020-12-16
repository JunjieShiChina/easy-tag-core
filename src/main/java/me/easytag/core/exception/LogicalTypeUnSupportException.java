package me.easytag.core.exception;

/**
 * 数据类型不匹配异常
 */
public class LogicalTypeUnSupportException extends RuntimeException {
    public LogicalTypeUnSupportException(String message) {
        super(message);
    }
}
