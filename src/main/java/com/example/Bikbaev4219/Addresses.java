package com.example.Bikbaev4219;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Addresses {
    @Bean
    public String address() {
        return "Green Street, 102";
    }
}
