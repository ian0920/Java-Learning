package com.ianlearning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

    public static void main(String[] args) {

        Vehicle vehicle = new Bicycle();

        Traveler traveler = new Traveler(vehicle);
        traveler.startJourney();

        //Creating Spring IoC Container
        //Read the configuration class
        //Create and manage Spring Beans(Object)
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //Retrieve Spring Bean from Spring IoC container

        Car car = applicationContext.getBean(Car.class);
        car.move();

        Traveler traveler1 = applicationContext.getBean(Traveler.class);
        traveler1.startJourney();





    }
}
