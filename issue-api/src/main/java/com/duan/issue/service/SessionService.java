package com.duan.issue.service;

import com.duan.issue.service.grpc.GRpcCglibProxy;
import com.duan.issue.service.grpc.GRpcClientManager;
import com.duan.issue.service.grpc.interfaces.Session;
import com.duan.session.Service;
import com.duan.session.SessionServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/11/14.
 *
 * @author DuanJiaNing
 */
@Component
public class SessionService extends GRpcCglibProxy<SessionServiceGrpc.SessionServiceBlockingStub, Session> implements Session {

    @Autowired
    private GRpcClientManager gRpcClientManager;

//    private SessionServiceGrpc.SessionServiceBlockingStub getStub(GRpcClientManager.Channel channel) {
//        return SessionServiceGrpc.newBlockingStub(channel.getChannel());
//    }

    @Override
    public int userCountInSession(String sessionId) {
//        GRpcClientManager.Channel channel = gRpcClientManager.getChannel();
//        SessionServiceGrpc.SessionServiceBlockingStub stub = getStub(channel);
        Service.UserCountInSessionRequest request = Service.UserCountInSessionRequest.newBuilder()
                .setSessionId(sessionId)
                .build();


        SessionServiceGrpc.SessionServiceBlockingStub stub = GRpcCglibProxy.getProxy(SessionServiceGrpc.SessionServiceBlockingStub.class);
        Service.UserCountInSessionResponse response = stub.userCountInSession(request);
//        channel.shutdown();

        int count = response.getCount();
        return count;
    }

}
