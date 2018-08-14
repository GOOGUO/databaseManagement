package com.jnj.edg.configurers;
/*
Author:chen shanshan
Description:gemfire配置类
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.config.annotation.CacheServerConfigurer;

public class ServerApplication {
    @Bean
    CacheServerConfigurer cacheServerPortConfigurer(
            @Value("${gemfire.cache.server.host:localhost}") String cacheServerHost,
            @Value("${gemfire.cache.server.port:40404}") int cacheServerPort) {

        return (beanName, cacheServerFactoryBean) -> {
            cacheServerFactoryBean.setBindAddress(cacheServerHost);
            cacheServerFactoryBean.setHostNameForClients(cacheServerHost);
            cacheServerFactoryBean.setPort(cacheServerPort);
        };
    }
}

