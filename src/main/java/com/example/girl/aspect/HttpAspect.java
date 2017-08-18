package com.example.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    @Pointcut(value = "execution(public * com.example.girl.controller.GirlController.*(..))")
    public void log() {
    }

    @Before(value = "log()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("HttpAspect.log 111111");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", " " + request.getRequestURL());
        //logger.info("url=" + request.getRequestURL());


        //method
        logger.info("method={}", " " + request.getMethod());

        //ip
        logger.info("getRemoteAddr={}", " " + request.getRemoteAddr());

        //class method
        logger.info("getSignature={}", " " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //Parameter
        logger.info("getArgs={}", joinPoint.getArgs()[0]);

        //other
        logger.info("getContextPath={}", " " + request.getContextPath());
        logger.info("getHeaderNames={}", " " + request.getHeaderNames()
        );


    }

    @After(value = "log()")
    public void doAfter() {
        logger.info("HttpAspect.doAfter 2222222");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("respons={}", object.toString());
    }


}
