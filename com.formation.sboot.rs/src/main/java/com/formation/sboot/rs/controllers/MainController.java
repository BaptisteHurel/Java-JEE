package com.formation.sboot.rs.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/main")
public class MainController {
    private final static Logger Log = LoggerFactory.getLogger(MainController.class);

    @GetMapping({"","/date", "/time",})
    public String now() {
        String msg = String.format("Nous sommes le %");
        return msg;
    }

    @RequestMapping(value="/hello")
    public String sayHello(@RequestParam(required = false) String name){
        return String.format("Hello %s !", name !=null?name: "Hello inconnue");
    }

    @RequestMapping(value="/hi/{nom}")
    public String sayHi(@PathVariable(required = false) String name){
        return String.format("Hi %s !", name !=null?name: "guy");
    }
}

