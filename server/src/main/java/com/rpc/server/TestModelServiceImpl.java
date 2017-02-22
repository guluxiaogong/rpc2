package com.rpc.server;

import com.rpc.commons.RpcService;
import com.rpc.interf.TestModelService;
import com.rpc.test.model.UserModel;

/**
 * Created by Administrator on 2017/2/22.
 */
@RpcService(TestModelService.class) // 指定远程接口
public class TestModelServiceImpl implements TestModelService {
    @Override
    public UserModel getUserModel() {
        UserModel userModel = new UserModel();
        userModel.setId(11);
        userModel.setName("zhangsan");
        //userModel.setAge(15);
        return userModel;
    }
}
