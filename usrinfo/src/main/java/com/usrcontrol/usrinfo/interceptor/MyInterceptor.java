package com.usrcontrol.usrinfo.interceptor;

import com.usrcontrol.usrinfo.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class MyInterceptor {
    @Pointcut("within (com.usrcontrol.usrinfo.controller..*) && !within (com.usrcontrol.usrinfo.controller.admin.LoginController)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object trackInfo(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            System.out.println("User is not logged in");
            attributes.getResponse().sendRedirect("/login");
        }
        System.out.println(user + "User Login");
        return joinPoint.proceed();
    }
}
