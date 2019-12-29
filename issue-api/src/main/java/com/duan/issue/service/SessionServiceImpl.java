package com.duan.issue.service;

import com.duan.issue.common.annotations.GRpcService;
import com.duan.issue.service.grpc.GRpcServiceProxy;
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
@GRpcService
public class SessionServiceImpl implements SessionService {

    @Override
    public long parliamentaryCountInSession(long sessionId) {
        Service.ParliamentaryCountInSessionRequest request = Service.ParliamentaryCountInSessionRequest.newBuilder()
                .setSessionId(sessionId)
                .build();

        SessionServiceGrpc.SessionServiceBlockingStub stub = GRpcServiceProxy.getStub(SessionServiceGrpc::newBlockingStub);
        Service.ParliamentaryCountInSessionResponse response = stub.parliamentaryCountInSession(request);
        return response.getCount();
    }

}
