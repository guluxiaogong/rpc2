package com.rpc.client;

import com.rpc.commons.InstanceService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/2/22.
 */
public class RpcBootstrap {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        RpcProxy rpcProxy=(RpcProxy)context.getBean("rpcProxy");
        InstanceService instanceService=(InstanceService)context.getBean("instanceService");
        instanceService.getAllInterface();
    }
}
