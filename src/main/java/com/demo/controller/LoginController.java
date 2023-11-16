package com.demo.controller;

import com.demo.dto.LoginParam;
import com.demo.dto.Msg;
import com.demo.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
public class LoginController {
    @Resource
    LoginService loginService;

    @RequestMapping("/login")
    public Msg login(@RequestBody LoginParam p) {
        return loginService.login(p);
    }

    @RequestMapping("/logout")
    public Msg logout() {
        return loginService.logout();
    }
}