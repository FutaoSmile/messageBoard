package com.up.study.message.board.framework.exception;

import java.util.function.Supplier;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
public class ApplicationException extends RuntimeException {
    private ApplicationException() {
    }

    private ApplicationException(String message) {
        super(message);
    }

    private ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public static ApplicationException ae(String message) {
        return new ApplicationException(message);
    }

    public static ApplicationException ae(String message, Throwable e) {
        return new ApplicationException(message, e);
    }

    public static Supplier<ApplicationException> aes(String msg) {
        return () -> ApplicationException.ae(msg);
    }

    public static Supplier<ApplicationException> aes(String msg, Throwable e) {
        return () -> ApplicationException.ae(msg, e);
    }
}
