package com.up.study.message.board.framework.exception;

import com.up.study.message.board.framework.restful.constants.ResponseCodes;
import lombok.Getter;

import java.util.function.Supplier;

/**
 * 逻辑异常
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
public class LogicException extends RuntimeException {
    private final Integer code;

    private LogicException(String message, int code) {
        super(message);
        this.code = code;
    }

    public static LogicException le(String msg, int code) {
        return new LogicException(msg, code);
    }

    public static LogicException le(String msg) {
        return le(msg, ResponseCodes.LOGIC_FAIL);
    }

    public static void leThrow(String msg) {
        throw le(msg, ResponseCodes.LOGIC_FAIL);
    }

    public static Supplier<LogicException> les(String msg) {
        return () -> LogicException.le(msg);
    }

    public static Supplier<LogicException> les(String msg, int code) {
        return () -> LogicException.le(msg, code);
    }
}
