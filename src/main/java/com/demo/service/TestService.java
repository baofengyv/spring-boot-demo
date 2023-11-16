package com.demo.service;

import com.demo.dto.Msg;
import com.demo.entity.Temp;
import com.demo.entity.TempExample;
import com.demo.entity.User;
import com.demo.mapper.TempMapper;
import com.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class TestService {
    @Resource
    TempMapper tempMapper;

    @Resource
    UserMapper userMapper;

    public Msg test() {

        List<Temp> list = tempMapper.selectByExample(new TempExample());

        Map m = new HashMap();
        m.put("list",list);

        return new Msg(9, "hjh",m);
    }


    @Transactional
    public Msg test2() {

        List<Temp> list = tempMapper.selectByExample(new TempExample());


        User user = new User();

        user.setUsername("rerer");
        user.setPassword("fserere");
        user.setRoles("fwe,ere,w,er,d,r");

        int i = userMapper.insert(user);

        // 抛出异常事务回滚
//        if(true)
//            throw new Exception();

        return new Msg(99, "this is test2",i);
    }
}