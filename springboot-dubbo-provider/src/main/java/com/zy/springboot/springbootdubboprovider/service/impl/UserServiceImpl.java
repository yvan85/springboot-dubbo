package com.zy.springboot.springbootdubboprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zy.springboot.bean.User;
import com.zy.springboot.service.UserService;
import org.springframework.stereotype.Component;

@Component
@Service(version = "1.0.1",timeout = 100000)  //dubbo 注解，有别于Spring的注解
public class UserServiceImpl implements UserService {
    @Override
    public String sayHii(String name) {
        return "Hello,"+name;
    }

    @Override
    public User getUser(int id) {
        User user = new User();
        user.setId(1);
        user.setName("zy");
        user.setPhone("123456");
        return user;
    }
}
