package com.liuchenxi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private DiscoveryClient discoveryClient;
//    @RequestMapping("/getMember")
//    public String getMember() {
//        return "this is getMember";
//    }

    @RequestMapping("/getServiceUrl")
    public List<String> getServiceUrl() {
        List<ServiceInstance> list = discoveryClient.getInstances("app-member");
        List<String> services = new ArrayList<>();
        for (ServiceInstance serviceInstance : list) {
            if (serviceInstance != null) {
                services.add(serviceInstance.getUri().toString());
            }
        }
        return services;
    }
}
