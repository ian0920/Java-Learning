package com.ianlearning;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Vehicle car (){
        return new Car();
    }

    @Bean
    public Vehicle bike (){
        return new Bike();
    }

    @Bean
    public Vehicle bicycle (){
        return new Bicycle();

    }

    @Bean
    public Traveler traveler (){
        return new Traveler(car());  //dependency injection
    }



}
