package com.demo.annotation;

import com.demo.util.AuthUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 切面，做用户权限检查
 */

@Component
@Aspect
public class AuthRoleAspect {

    @Pointcut("@annotation(com.demo.annotation.AuthRole)")
    private void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {

        // 获取到注解配置的role
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();
        AuthRole authRole = method.getAnnotation(AuthRole.class);
        String role = authRole.value();

        AuthUtil.check(role);
    }
}
