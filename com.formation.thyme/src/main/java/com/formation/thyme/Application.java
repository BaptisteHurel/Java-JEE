package com.formation.thyme;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Value("${product.version}")
	private String VERSION  ;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public String getVERSION() {
		return VERSION;
	}
}
