package com.gaofei.exception;

/**
 * Created by GaoQingming on 2017/11/16 0016.
 */
public class MydubboException extends RuntimeException {
    public MydubboException() {
        super();
    }

    public MydubboException(String message) {
        super(message);
    }

    public MydubboException(String message, Throwable cause) {
        super(message, cause);
    }

    public MydubboException(Throwable cause) {
        super(cause);
    }

    protected MydubboException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
