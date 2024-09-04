package com.automaterijal.application;

import com.automaterijal.application.services.onstartup.OnStartUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAsync
public class Application {

    @Autowired
    OnStartUpService onStartUpService;

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Init method to get all required data to for the application to run
     */
    @PostConstruct
    public void init() {
//    onStartUpService.izvadiSlikeIzAtributaIStoruj();
//    onStartUpService.loadTecDocAmBrands();
    }
}