package com.xebia;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

@Import(DefaultConfig.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
