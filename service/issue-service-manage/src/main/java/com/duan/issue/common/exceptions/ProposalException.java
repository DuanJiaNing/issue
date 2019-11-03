package com.duan.issue.common.exceptions;

/**
 * Created on 2019/10/28.
 *
 * @author DuanJiaNing
 */
public class ProposalException extends ManageException {
    public ProposalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProposalException(String message) {
        super(message);
    }
}
