package com.restaurant.ex3.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @AfterThrowing(
            pointcut = "execution(* com.restaurant.ex3.service.*.*(..))",
            throwing = "ex"
    )
    public void logError(
            JoinPoint joinPoint,
            Exception ex
    ) {

        System.out.println("====== ERROR LOG ======");

        System.out.println(
                "Method: " + joinPoint.getSignature().getName()
        );

        System.out.println(
                "Message: " + ex.getMessage()
        );

        System.out.println("=======================");
    }
}