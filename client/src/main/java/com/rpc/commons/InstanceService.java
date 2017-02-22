package com.rpc.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
public class InstanceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(InstanceService.class);
    private String interfacePackage;

    public InstanceService() {
    }

    public InstanceService(String interfacePackage) {
        this.interfacePackage = interfacePackage;
    }

    public void getAllInterface() {
        if (interfacePackage == null || "".equals(interfacePackage)) {
            LOGGER.warn("interface package is empty...");
            return;
        }
        String packName = interfacePackage.replaceAll("\\.", "/");
        System.out.println("-----------------------" + packName);
        File file = new File(Class.class.getClass().getResource("/").getPath() + "/" + packName);
        System.out.println(file);

        List<String> list = new ArrayList<>();
        File[] tempList = file.listFiles();
        System.out.println("该目录下对象个数：" + tempList.length);
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                System.out.println("文     件：" + tempList[i]);
                String packge = tempList[i].toString();
                String packClass = interfacePackage + "." + packge.substring(packge.lastIndexOf("\\") + 1);
                list.add(packName + packge.substring(packge.lastIndexOf("\\") + 1));

                System.out.println("====================================\r\n" + interfacePackage + "." + packge.substring(packge.lastIndexOf("\\") + 1));
                Class inteClass = null;
                try {
                    inteClass = Class.forName(packClass);
                    Object o = inteClass.newInstance();
                    System.out.println("===================================="+o);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
