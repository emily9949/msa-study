package com.sumin.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // eureka 를 사용하려면 어노테이션을 달아야한다.
public class Chap0101EurekaServerLectureSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap0101EurekaServerLectureSourceApplication.class, args);
    }

}
