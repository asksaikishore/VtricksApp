package com.example.shipment.vtricks.AOP;


import com.example.shipment.vtricks.entity.Ship;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class LoggingConfig {

    Logger log= LoggerFactory.getLogger("LoggingConfig.class");
    @Before("execution(* com.example.shipment.vtricks.controller.ShipmentController.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("Before Aspect called");
        log.info("Before called");
        log.info(joinPoint.getSignature().getName());
        log.info(Arrays.toString(joinPoint.getArgs()));
        log.info("Before return "+ joinPoint.getThis().toString());

    }
    @After("execution(* com.example.shipment.vtricks.controller.ShipmentController.*(..))")
    public void after(JoinPoint joinPoint){
        System.out.println("After Aspect invoked");
        log.info("After called");
        log.info(joinPoint.getSignature().getName());
        log.info(joinPoint.getSignature().toString());
        log.info("After return "+ joinPoint.getThis().toString());

    }
//    @Around("execution(* com.example.shipment.vtricks.controller.ShipmentController.*(..))")
    @Around("ShipmentPointCut()")
    public Object aroundCall(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Aspect invoked");
        log.info(joinPoint.getSignature().getName());
        Object obj=joinPoint.proceed();
        if(obj instanceof ResponseEntity){
            log.info("returned oject is "+((ResponseEntity<?>) obj).getBody().toString());
        }
        log.info("returned oject is "+obj.toString());


        return obj;
    }

    @Pointcut("within(com.example.shipment.vtricks.controller.ShipmentController..*)")
    public void ShipmentPointCut(){}



}

