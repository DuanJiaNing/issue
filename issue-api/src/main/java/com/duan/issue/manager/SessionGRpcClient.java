package com.duan.issue.manager;


import com.duan.session.Service.JoinRequest;
import com.duan.session.Service.JoinResponse;
import com.duan.session.Service.UserSessionData;
import com.duan.session.SessionServiceGrpc;
import io.grpc.Channel;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class SessionGRpcClient {

    @GrpcClient("session-grpc")
    private Channel serverChannel;

    // TODO
    public String join(String name) {
        SessionServiceGrpc.SessionServiceBlockingStub stub = SessionServiceGrpc.newBlockingStub(serverChannel);
        JoinRequest request = JoinRequest.newBuilder().setUserId(name).build();
        JoinResponse response = stub.join(request);
        UserSessionData userSession = response.getUserSession();
        return userSession.getUser().getUserId();
    }

}
