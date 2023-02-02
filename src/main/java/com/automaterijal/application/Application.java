package com.automaterijal.application;

import com.automaterijal.application.services.onstartup.OnStartUpService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Application extends SpringBootServletInitializer {

  @Autowired
  OnStartUpService onStartUpService;

  // You need to extend SpringBootServletInitializer for tomcat server
//    public static void main(final String[] args) {
//        SpringApplication.run(Application.class, args);
//    }

  /**
   * Init method to get all required data to for the application to run
   */
  @PostConstruct
  public void init() {
    onStartUpService.izvadiSlikeIzAtributaIStoruj();
    onStartUpService.loadTecDocAmBrands();
  }
}