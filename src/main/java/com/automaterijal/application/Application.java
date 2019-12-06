package com.automaterijal.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class Application extends SpringBootServletInitializer {
    // You need to extend SpringBootServletInitializer for tomcat server

//    public static void main(final String[] args) {
//        SpringApplication.run(Application.class, args);
//    }
}
