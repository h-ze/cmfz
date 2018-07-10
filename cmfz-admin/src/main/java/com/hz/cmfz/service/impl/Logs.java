package com.hz.cmfz.service.impl;

import com.hz.cmfz.entity.Log;
import com.hz.cmfz.entity.Manager;
import com.hz.cmfz.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * Created by 11022 on 2018/7/9 0009.
 */

@Aspect
public class Logs {


    @Pointcut("execution(* com.hz.cmfz.service.impl.*.modify*(..))||execution(* com.hz.cmfz.service.impl.*.add*(..))||execution(* com.hz.cmfz.service.impl.*.remove*(..))")
    public void pc(){}



    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("12345678");

        Object obj = null;

        String logId = UUID.randomUUID().toString().replace("-", "");


        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        HttpSession session = request.getSession();

        Manager manager= (Manager) session.getAttribute("user");

        String username =manager.getMgrName();

        System.out.println(username);

        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();

        String resource = pjp.getTarget().getClass().getSimpleName().replace("ServiceImpl", "");
        System.out.println(resource+"123");

        Method method = methodSignature.getMethod();

        String action = method.getName();

        System.out.println(action+"456");
        StringBuilder message = new StringBuilder();

        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            message.append(arg+";");
        }
        System.out.println(message.append(args+"000"));
        String result = "false";

        System.out.println(result+"789");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        LogService logService = (LogService) applicationContext.getBean("logServiceImpl");

        Log log = new Log(logId,username, new Date(), resource, action, message.toString(), result);
        System.out.println(log);

        logService.LogAdd(log);

        return obj;

    }
}
