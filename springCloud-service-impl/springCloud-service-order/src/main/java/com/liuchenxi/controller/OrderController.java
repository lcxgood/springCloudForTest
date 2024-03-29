package com.liuchenxi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Api("订单基础接口")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;



    @RequestMapping("/getOrder")
    public String getOrder() {

        // order 使用rpc 远程调用技术 调用 会员服务
        String memberUrl = "http://app-member/getMember";
        String result = restTemplate.getForObject(memberUrl, String.class);
        System.out.println("会员服务调用订单服务,result:" + result);
        return result;
    }

    @ApiOperation("hello")
    @RequestMapping("/")
    public String index() {
        return "我是订单服务项目";
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
