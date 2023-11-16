package com.demo.util;

import com.demo.exception.Err;
import com.demo.exception.Excpt;

public class AuthUtil {

    public static void check(String role) {

        // 获取session中的角色
        String roles = SessionUtil.getRoles();

        if (roles == null)
            throw new Excpt(Err.未登录);

        String[] roleList = roles.split(",");

        // 检查有没有当权需要的角色
        for (String r : roleList) {
            if (role.equals(r)) return;
        }

        // 否则 返回无权限
        throw new Excpt(Err.无权限);
    }
}
