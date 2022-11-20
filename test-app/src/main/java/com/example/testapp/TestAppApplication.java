package com.example.testapp;

import configuration.DynamicBeanConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import service.TestDynamicBean;
import service.TestService;

import java.util.Map;

@SpringBootApplication
public class TestAppApplication implements CommandLineRunner {

    @Autowired
    private TestService testService;

    @Autowired
    private DynamicBeanConfiguration dynamicBeanMap;

    @Autowired(required = false)
    @Qualifier("service1")
    private TestDynamicBean service1;

    @Autowired(required = false)
    @Qualifier("service2")
    private TestDynamicBean service2;

    @Autowired(required = false)
    @Qualifier("serviceN")
    private TestDynamicBean serviceN;

    public static void main(String[] args) {
        SpringApplication.run(TestAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(testService.generateString());
        System.out.println(service1.printSomething());
        System.out.println(service2.printSomething());
        System.out.println(serviceN.printSomething());
    }
}
