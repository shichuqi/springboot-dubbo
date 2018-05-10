package com.example.springbootdubbodemoclient.modul.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.bese.BaseController;
import com.example.serviceApi.test.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/test/")
public class ITestController extends BaseController {

    @Reference(version="0.0.1")
    private TestService service;

    @GetMapping("sayHello")
    @ResponseBody
    public Object findHelloWorld(){
        return service.findHelloworld();
    }

    @GetMapping("returnGet")
    @ResponseBody
    public Object returnGet(){
        Map map=this.getParameter();
        return map;
    }

}
