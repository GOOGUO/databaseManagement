package com.jnj.edg;

import com.jnj.edg.entity.Book;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnablePdx;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;


@SpringBootApplication
@ClientCacheApplication(name = "geodeDemo", logLevel = "debug", locators = {@ClientCacheApplication.Locator(host = "locallhost", port = 10334)})
@EnableGemfireRepositories(basePackages = "com.jnj.edg.repository")
@EnableEntityDefinedRegions(basePackageClasses = Book.class, clientRegionShortcut = ClientRegionShortcut.PROXY)
@EnablePdx


public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
