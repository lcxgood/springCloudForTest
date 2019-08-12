package com.liuchenxi.api.feign;

import com.liuchenxi.api.service.IMemberService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 通过注册中心调用接口
 */
@FeignClient("app-member")
public interface MemberServiceFeign extends IMemberService {

}
