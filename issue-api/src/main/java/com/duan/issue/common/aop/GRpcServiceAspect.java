package com.duan.issue.common.aop;

import com.duan.issue.service.grpc.GRpcServiceProxy;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/11/26.
 *
 * @author DuanJiaNing
 */
@Aspect
@Component
public class GRpcServiceAspect {

    private static final Logger log = LoggerFactory.getLogger(GRpcServiceAspect.class);

    @Pointcut(value = "@within(com.duan.issue.common.annotations.GRpcService) || " +
            "@annotation(com.duan.issue.common.annotations.GRpcService)")
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void before() {
        log.info("grpc service proxy prepare...");
        GRpcServiceProxy.prepare();
    }

    @After(value = "pointCut()")
    public void after() {
        try {
            log.info("grpc service proxy will be shutdown");
            GRpcServiceProxy.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
