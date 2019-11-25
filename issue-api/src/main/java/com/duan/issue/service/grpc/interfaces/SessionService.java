package com.duan.issue.service.grpc.interfaces;

/**
 * Created on 2019/11/14.
 *
 * @author DuanJiaNing
 */
public interface SessionService {

    int userCountInSession(long sessionId);

}
