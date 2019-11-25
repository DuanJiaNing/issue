package com.duan.issue.service;

import com.duan.issue.service.grpc.GRpcCglibProxy;
import com.duan.issue.service.grpc.interfaces.SessionService;
import com.duan.session.Service;
import com.duan.session.SessionServiceGrpc;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/11/14.
 *
 * @author DuanJiaNing
 */
@Component
public class SessionServiceImpl implements SessionService {

    @Override
    public int userCountInSession(long sessionId) {
        Service.UserCountInSessionRequest request = Service.UserCountInSessionRequest.newBuilder()
                .setSessionId(sessionId)
                .build();

        // FIX Cannot subclass final class class com.duan.session.SessionServiceGrpc$SessionServiceBlockingStub
        SessionServiceGrpc.SessionServiceBlockingStub stub = GRpcCglibProxy.getProxy(SessionServiceGrpc.SessionServiceBlockingStub.class);
        Service.UserCountInSessionResponse response = stub.userCountInSession(request);
        int count = response.getCount();
        return count;
    }

}
