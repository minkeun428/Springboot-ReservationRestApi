package com.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication   // 가장 먼저 실행되어야 할 클래스를 알려준다.
public class startApplication {
    public static void main(String[] args) {
        //이 프로젝트를 실행하겠다.
        SpringApplication.run(startApplication.class, args);
        System.out.println("Hello!!");
    }
}
