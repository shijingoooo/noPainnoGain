package com.shijing.nopainnogain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class NopainnogainApplication extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(NopainnogainApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(NopainnogainApplication.class, args);
    }

}
