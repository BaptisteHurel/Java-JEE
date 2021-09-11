package com.formation.thyme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
    @RequestMapping("/")
        @SessionAttributes({"userValid","version","message"})
public class WelcomeController {

    @Autowired
    private String version;

    @GetMapping
    public String welcome(Model model){
        String msg = String.format("Version : %s",
                version);
        model.addAttribute("message",msg);
        model.addAttribute("version",version);
        return "welcome";
    }
}
