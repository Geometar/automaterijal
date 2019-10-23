package com.automaterijal.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping({
            "/",
            "/naslovna",
            "/o-nama",
            "/kontakt",
            "/roba",
            "/filteri",
            "/ulja",
            "/akumulatori",
            "/ostalo",
            "//ostalo/**",
            "/login",
            "/korpa",
            "/reset-sifre",
            "/porudzbenice/**",
            "/porudzbenice",
            "/reset-sifre/**"})
    public String index() {
        return "forward:/index.html";
    }
}
