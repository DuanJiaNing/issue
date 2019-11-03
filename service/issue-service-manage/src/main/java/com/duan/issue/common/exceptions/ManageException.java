package com.duan.issue.common.exceptions;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
public class ManageException extends Throwable {
    public ManageException() {
    }

    public ManageException(String message) {
        super(message);
    }

    public ManageException(String message, Throwable cause) {
        super(message, cause);
    }

    public ManageException(Throwable cause) {
        super(cause);
    }

    public ManageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
