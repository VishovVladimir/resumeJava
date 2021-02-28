package com.example.resume.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.example.resume.service.PeopleServiceImpl.*(..))")
    public void callAtPeopleServicePublic() {
    }

    @Before("callAtPeopleServicePublic()")
    public void beforeCallAtService(JoinPoint jp) {
        logger.info("MyLogger "+jp.toString());
    }


}
