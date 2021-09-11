package com.formation.sboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
    @RequestMapping({"","/"})
public class MainController {

    @GetMapping
    public String starter(){
        return "<h2 style=\"color:lightgreen;text-align: center; \">Server Started at : "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("eeee dd MMMM yyyy HH:mm:ss.SSS"))+"</h2>";
    }
}
