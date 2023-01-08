package com.findgeo;

import javax.servlet.http.HttpSessionListener;

import org.apache.catalina.SessionEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.findgeo.config.SessionListener;

@SpringBootApplication
@EnableJpaAuditing
public class FindGeoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindGeoApplication.class, args);
	}
	
	@Bean
	public HttpSessionListener httpSessionListener(){

	    return new SessionListener();
		
	}
	
}
