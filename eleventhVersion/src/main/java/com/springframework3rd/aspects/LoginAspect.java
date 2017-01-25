package com.springframework3rd.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoginAspect {
    private Logger logger = Logger.getLogger(LoginAspect.class);

    @Before(value = "execution(* com.springframework3rd.service.*Service.*(..))")
    public void log(JoinPoint joinPoint) {
        logger.info("Entering "
                + joinPoint.getTarget().getClass().getSimpleName() + "'s"
                + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        for(int i = 0; i < args.length; i++) {
            logger.info("args[" + i + "] -->" + args[i]);
        }
    }
}
