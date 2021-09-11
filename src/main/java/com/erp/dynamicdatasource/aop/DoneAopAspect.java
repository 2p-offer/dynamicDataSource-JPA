package com.erp.dynamicdatasource.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author 2p
 * @date 2021/9/9 11:28
 * @desc DoneAopAspect
 */
@Order(0)
@Aspect
@Component
public class DoneAopAspect {

    @Pointcut("execution(public * com.erp.dynamicdatasource.controller.*Controller.*Do(..))")
    public void workDo() {
    }

    @AfterReturning("workDo()")
    public void AfterDo(JoinPoint joinPoint) throws Throwable {
        System.out.println("................................" + Arrays.toString(joinPoint.getArgs()));
    }


}
