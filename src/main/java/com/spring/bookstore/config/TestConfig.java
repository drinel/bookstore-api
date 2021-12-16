package com.spring.bookstore.config;

import com.spring.bookstore.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService service;

    @Bean
    public void instanciar(){
        this.service.instanciarBanco();
    }
}
