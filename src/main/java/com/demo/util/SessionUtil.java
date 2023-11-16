package com.demo.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

public class SessionUtil {

    private static final String ROLES_NAME = "ROLES";

    public static void setRoles(String roles) {
        getSession().setAttribute(ROLES_NAME, roles);
    }

    public static String getRoles() {
        return (String) getSession().getAttribute(ROLES_NAME);
    }

    public static void removeRoles() {
        getSession().removeAttribute(ROLES_NAME);
    }

    public static HttpSession getSession() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getSession();
    }
}
