package com.automaterijal.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

  @RequestMapping("/{path:[^\\.]*}") // Matches all paths except ones with a dot (.)
  public String index() {
    return "forward:/index.html";
  }
}
