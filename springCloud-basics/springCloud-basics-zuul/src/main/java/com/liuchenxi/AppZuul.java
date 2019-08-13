package com.liuchenxi;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2Doc
public class AppZuul {

    public static void main(String[] args) {
        SpringApplication.run(AppZuul.class, args);
    }

}