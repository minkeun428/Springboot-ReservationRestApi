package com.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication   // 가장 먼저 실행되어야 할 클래스를 알려준다.
public class StartApplication {
    public static void main(String[] args) {
        //이 프로젝트를 실행하겠다. -> 내장 WAS 실행. -> 스프링부트로 만들어진 Jar파일 실행 (spring-boot-stater-tomcat)
        SpringApplication.run(StartApplication.class, args);
    }
}
