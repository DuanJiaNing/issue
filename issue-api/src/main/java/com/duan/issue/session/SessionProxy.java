package com.duan.issue.session;

import com.duan.issue.config.Config;
import com.duan.session.SessionServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/11/09.
 *
 * @author DuanJiaNing
 */
@Component
public class SessionProxy {

    @Autowired
    private Config config;

    private SessionServiceGrpc.SessionServiceBlockingStub client;

    private void init() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(config.getSession().getHost(),
                config.getSession().getPort())
                .usePlaintext(true)
                .build();
        client = SessionServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        // TODO
//        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /*
    public void greet(String name) {
        Service.JoinRequest request = Service.JoinRequest.newBuilder()
                .setSessionId("")
                .build();

        Service.JoinResponse response = blockingStub.join(request);
        System.out.println(response.getUserSession());
    }
*/
}
