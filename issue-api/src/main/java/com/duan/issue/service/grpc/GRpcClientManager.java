package com.duan.issue.service.grpc;

import com.duan.issue.config.Config;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created on 2019/11/14.
 *
 * @author DuanJiaNing
 */
@Component
public class GRpcClientManager {

    @Autowired
    private Config config;

    private ThreadLocal<Channel> threadChannel = new ThreadLocal<>();
    private static final int channel_shutdown_timeout = 5;

    // always close after use
    public Channel getChannel() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(config.getGrpc().getHost(), config.getGrpc().getPort())
                .disableRetry()
                .usePlaintext()
                .idleTimeout(2, TimeUnit.SECONDS)
                .build();
        Channel internalManagedChannel = new Channel(channel);
        threadChannel.set(internalManagedChannel);
        return internalManagedChannel;
    }

    public static class Channel {

        private ManagedChannel channel;

        public Channel(ManagedChannel channel) {
            this.channel = channel;
        }

        public ManagedChannel getChannel() {
            return channel;
        }

        public void shutdown() {
            if (channel != null) {
                if (!channel.isShutdown()) {
                    try {
                        channel.shutdown().awaitTermination(channel_shutdown_timeout, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
