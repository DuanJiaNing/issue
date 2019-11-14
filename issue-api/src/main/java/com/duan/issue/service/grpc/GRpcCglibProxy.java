package com.duan.issue.service.grpc;

import com.duan.session.SessionServiceGrpc;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

/**
 * Created on 2019/11/14.
 *
 * @author DuanJiaNing
 */
public class GRpcCglibProxy implements MethodInterceptor {

    private GRpcClientManager.Channel channel;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        Object res = methodProxy.invokeSuper(o, objects);
        channel.shutdown();
        return res;
    }

    private GRpcCglibProxy() {
    }

    public static <Stub> Stub getProxy(Class<Stub> stubClass) {
        SessionServiceGrpc.newBlockingStub(channel.getChannel());
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(stubClass);
        enhancer.setCallback(new GRpcCglibProxy());
        return (Stub) enhancer.create();
    }

}
