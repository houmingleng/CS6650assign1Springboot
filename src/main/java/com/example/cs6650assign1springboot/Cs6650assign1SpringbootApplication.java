package com.example.cs6650assign1springboot;

import com.example.cs6650assign1springboot.controller.ServletSkierServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = ServletSkierServlet.class)
public class Cs6650assign1SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cs6650assign1SpringbootApplication.class, args);
    }

}
