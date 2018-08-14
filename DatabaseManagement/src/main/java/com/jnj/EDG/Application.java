package com.jnj.EDG;


//import com.jnj.EDG.repository.BookRepository;
//

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Collections;

@SpringBootApplication()
//@ClientCacheApplication(name = "geodeDemo", logLevel = "debug",locators = {@ClientCacheApplication.Locator()})
//@EnableGemfireRepositories(basePackages = "com.jnj.EDG.file.repository")
//@EnableEntityDefinedRegions(basePackageClasses = Book.class, clientRegionShortcut = ClientRegionShortcut.LOCAL)
//@EnablePdx
public class Application {

    public static void main(String[] args) {

        SpringApplication app =new SpringApplication(Application.class);

    }

}
