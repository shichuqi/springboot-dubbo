package com.example.springbootdubbodemoservice.modul.test.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.serviceApi.test.TestService;

@Service(version = "0.0.1")
public class ITestServiceImpl implements TestService {
    @Override
    public String findHelloworld() {
        return "Hello World!";
    }
}
