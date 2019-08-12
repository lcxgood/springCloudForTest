package com.liuchenxi.api.service.impl;

        import com.liuchenxi.api.entity.UserEntity;
        import com.liuchenxi.api.service.IMemberService;
        import com.liuchenxi.base.BaseApiMsg;
        import com.liuchenxi.base.ResponseBase;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberServiceImpl extends BaseApiMsg implements IMemberService {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/getMember")
    public UserEntity getMember(@RequestParam("name") String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name + "端口号:" + serverPort);
        userEntity.setAge(20);
        return userEntity;
    }

    @RequestMapping("/getUserInfo")
    public ResponseBase getUserInfo() {
        System.out.println(" 我是会员服务,订单服务调用会员服务开始啦！！");
        try {
            // 会员服务接口产生1.5秒的延迟
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return setResultSuccess("订单服务接口调用会员服务接口成功....");
    }

}
