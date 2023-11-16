package com.demo.service;

import com.demo.dto.LoginParam;
import com.demo.dto.Msg;
import com.demo.entity.User;
import com.demo.entity.UserExample;
import com.demo.exception.Err;
import com.demo.exception.Excpt;
import com.demo.mapper.UserMapper;
import com.demo.util.SessionUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginService {

    @Resource
    UserMapper userMapper;

    public Msg login(LoginParam p) {

        // 验证是否为空，是否超长等
        if (!checkLoginParam(p))
            throw new Excpt(Err.用户名密码校验失败);

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(p.getUsername())
                .andPasswordEqualTo(p.getPassword());

        List<User> userResult = userMapper.selectByExample(userExample);

        if (userResult.size() != 1)
            throw new Excpt(Err.用户名密码错误);

        String roles = userResult.get(0).getRoles();

        // 设置 用户名 角色到session中
        SessionUtil.setRoles(roles);

        return new Msg(0, "登录成功");
    }

    private boolean checkLoginParam(LoginParam p) {

        String password = p.getPassword();
        String username = p.getUsername();

        if (password == null || username == null) return false;

        if (password.isEmpty() || username.isEmpty()) return false;

        if (password.length() < 8 || password.length() > 64) return false;

        if (username.length() < 3 || username.length() > 64) return false;

        return true;
    }

    public Msg logout() {
        SessionUtil.removeRoles();
        return new Msg(0, "退出成功");
    }
}
