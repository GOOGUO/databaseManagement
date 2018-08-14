package com.jnj.edg.controller;
/*
Description:切换数据源的帮助类
 */

import com.jnj.edg.service.FileBookServicelmpl;
import com.jnj.edg.service.GemfireBookServiceImpl;
import com.jnj.edg.service.MysqlBookServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ControllerHelper {
    @Value("${database}")
    String database;

    private HashMap serviceMap = new HashMap();

    public ControllerHelper() {
        serviceMap.put("Mysql", new MysqlBookServiceImpl());
        serviceMap.put("Gemfire", new GemfireBookServiceImpl());
        serviceMap.put("File", new FileBookServicelmpl());

    }

    public Object getServiceMap() {
        return serviceMap.get(this.database);
    }
}
