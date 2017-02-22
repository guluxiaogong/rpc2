package com.rpc.server;

import com.rpc.commons.RpcService;
import com.rpc.interf.HelloService;

/**
 * Created by Administrator on 2017/2/22.
 */
@RpcService(HelloService.class) // 指定远程接口
public class HelloServiceImpl implements HelloService{
    @Override
    public String hello(String name) {
        return "Hello! " + name;
    }
}
