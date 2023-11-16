package com.demo.controller;

import com.demo.annotation.AuthRole;
import com.demo.dto.Msg;
import com.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    TestService testService;

    @AuthRole("TEST")
    @RequestMapping("/test")
    public Msg test() {
        return testService.test();
    }

    @AuthRole("TEST")
    @RequestMapping("/test2")
    public Msg test2() {
        return testService.test2();
    }
}