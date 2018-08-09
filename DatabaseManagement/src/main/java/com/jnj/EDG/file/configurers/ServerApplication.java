package com.jnj.EDG.configurers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.config.annotation.CacheServerConfigurer;
import org.springframework.data.gemfire.config.annotation.ClientCacheConfigurer;

import java.util.Collections;

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

/*    ClientCacheConfigurer clientCachePoolPortConfigurer(
            @Value("${gemfire.cache.server.host}") String cacheServerHost,
            @Value("${gemfire.cache.server.port}") int cacheServerPort) {
        return (beanName, clientCacheFactoryBean) -> {
            clientCacheFactoryBean.setServers(Collections.singletonList(new ConnectionEndpoint(cacheServerHost, cacheServerPort)));
        };
    }*/

