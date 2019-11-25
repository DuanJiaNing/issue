package com.duan.issue.service.grpc;

import com.duan.issue.utils.SpringUtil;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created on 2019/11/14.
 *
 * @author DuanJiaNing
 */
public class GRpcCglibProxy implements MethodInterceptor {

    private static final Logger log = LoggerFactory.getLogger(GRpcCglibProxy.class);

    private GRpcClientManager.Channel channel;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        try {
            log.info("cglib invoke [" + method.getName() + "] for gRpc");
            return methodProxy.invokeSuper(o, objects);
        } finally {
            log.info("channel shutdown");
            channel.shutdown();
        }

    }

    private GRpcCglibProxy(GRpcClientManager.Channel channel) {
        this.channel = channel;
    }

    public static <Stub> Stub getProxy(Class<Stub> stubClass) {
        GRpcClientManager manager = SpringUtil.getBean(GRpcClientManager.class);
        GRpcClientManager.Channel channel = manager.getChannel();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(stubClass);
        enhancer.setCallback(new GRpcCglibProxy(channel));
        return (Stub) enhancer.create();
    }

}
