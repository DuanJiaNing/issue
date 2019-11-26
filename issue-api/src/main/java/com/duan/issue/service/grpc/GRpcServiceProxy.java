package com.duan.issue.service.grpc;

import com.duan.issue.config.Config;
import com.duan.issue.utils.SpringUtil;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created on 2019/11/26.
 *
 * @author DuanJiaNing
 */
public class GRpcServiceProxy {
    private static final Logger log = LoggerFactory.getLogger(GRpcServiceProxy.class);

    private static final int channel_shutdown_timeout = 5;

    public static <Stub> Stub getStub(Function<ManagedChannel, Stub> fun) {
        log.info("create grpc service stub...");
        return fun.apply(Channel.get());
    }

    public static void shutdown() throws InterruptedException {
        Channel.shutdown();
    }

    public static void prepare() {
        Config config = SpringUtil.getBean(Config.class);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(config.getGrpc().getHost(), config.getGrpc().getPort())
                .disableRetry()
                .usePlaintext()
                .idleTimeout(2, TimeUnit.SECONDS)
                .build();
        Channel.set(channel);
    }

    static class Channel {
        private static final ThreadLocal<ManagedChannel> thread_channel = new ThreadLocal<>();

        static void set(ManagedChannel channel) {
            thread_channel.set(channel);
        }

        static ManagedChannel get() {
            return thread_channel.get();
        }

        static void shutdown() throws InterruptedException {
            ManagedChannel channel = thread_channel.get();
            if (channel != null) {
                if (!channel.isShutdown()) {
                    channel.shutdown().awaitTermination(channel_shutdown_timeout, TimeUnit.SECONDS);
                }
            }
        }

    }
}
