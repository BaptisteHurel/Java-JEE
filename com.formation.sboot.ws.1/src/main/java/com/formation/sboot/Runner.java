package com.formation.sboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Runner implements CommandLineRunner {
    private final static Logger log = LoggerFactory.getLogger(Runner.class);

    @Override
    public void run(String... args) throws Exception {
        String msg = String.format("Application Server STARTUP : %s ", LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE dd-MM-yyyy HH:mm:ss.SSS")));
        log.info("{}",msg);
    }
}
