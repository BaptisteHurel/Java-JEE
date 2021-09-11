package com.formation.sakila.rs.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/up")
public class UpController {
    private static final Logger log = LogManager.getLogger(UpController.class);

    private final static String VERSION = "1.0.1";

    @GetMapping({"", "/heure"})
    public String getHeureServeur() {
        return null;
    }

    @GetMapping({"", "/numversion"})
    public String getNumVersion() {
        return VERSION;
    }
}
