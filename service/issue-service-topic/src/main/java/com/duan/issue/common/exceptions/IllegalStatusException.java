package com.duan.issue.common.exceptions;

import com.duan.issue.common.TopicStatus;

/**
 * Created on 2019/11/1.
 *
 * @author DuanJiaNing
 */
public class IllegalStatusException extends TopicException {

    public IllegalStatusException(TopicStatus status) {
        super("Topic status illegal: " + status + ", conflict with current operational.");
    }
}
