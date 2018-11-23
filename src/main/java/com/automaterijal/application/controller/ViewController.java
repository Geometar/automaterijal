package com.automaterijal.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping({ "/naslovna", "/o-nama", "/kontakt", "/filteri", "/ulja", "/akumulatori", "/login", "/korpa"})
    public String index() {
        return "forward:/index.html";
    }
}
