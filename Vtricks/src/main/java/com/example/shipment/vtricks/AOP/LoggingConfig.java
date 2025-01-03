package com.example.shipment.vtricks.AOP;


import com.example.shipment.vtricks.Repository.Run_Feign;
import com.example.shipment.vtricks.Service.ShipServiceImpl;
import com.example.shipment.vtricks.config.DynamicRunValue;
import com.example.shipment.vtricks.entity.Run_Value;
import com.example.shipment.vtricks.entity.Ship;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.hibernate.internal.util.MarkerObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
@Aspect
public class LoggingConfig {

    Logger log= LoggerFactory.getLogger("LoggingConfig.class");
    @Autowired
    DynamicRunValue dyn;

    @Autowired
    ShipServiceImpl service;

    @Before("AllShipments() || generateCSV() " )
    public void beforeController(JoinPoint joinPoint) {

//        System.out.println(joinPoint.getClass());
        Run_Value run = new Run_Value();
         if( joinPoint.getArgs().length>0) {
             Object[] objarr = joinPoint.getArgs();
             if (objarr[0] != null) {
                 run.setOrder_ID((Integer) objarr[0]);
             }
             if (objarr[1] != null) {
                 run.setProducer_name(objarr[1].toString());
             }
             if (objarr[2] != null) {
                 run.setShip_name(objarr[2].toString());
             }
         }
        String Run_ID=service.createnewRun(run);
        log.info("Arguments called are" + Arrays.toString(joinPoint.getArgs())+" new Run ID generated is"+Run_ID);
        dyn.setDynamicRunId(Run_ID);
        dyn.setDynamicquery(run.getArgs());
        dyn.setDynamicHeaders(run.getHeaders());
        run.setRunId(Run_ID);
    }

    @Before("execution(* com.example.shipment.vtricks.controller.ShipmentController.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("Before Aspect called");
        log.info(joinPoint.getSignature().getName());
        log.info("Before return "+ joinPoint.getThis().toString());

    }

//    @After("execution(* com.example.shipment.vtricks.controller.ShipmentController.*(..))")
//    public void after(JoinPoint joinPoint){
//        System.out.println("After Aspect invoked");
//        log.info("After Aspect called");
//        log.info(joinPoint.getSignature().getName());
//        log.info(joinPoint.getSignature().toString());
//        log.info("After return "+ joinPoint.getThis().toString());
//
//    }
    @Around("execution(* com.example.shipment.vtricks.controller.ShipmentController.*(..))")
//    @Around("ShipmentPointCut()")
    public Object aroundCall(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Aspect invoked");
        long cur=System.currentTimeMillis();
        Object obj=joinPoint.proceed();
        long later=System.currentTimeMillis();
        log.info("method executed in "+(later-cur) +" milliseconds");
//        if(obj instanceof ResponseEntity){
//            log.info("returned oject is "+((ResponseEntity<?>) obj).getBody().toString());
//        }
//        log.info("returned oject is "+obj.toString());



        return obj;
    }
//
//    @Pointcut("within(com.example.shipment.vtricks.controller.ShipmentController..*)")
//    public void ShipmentPointCut(){}

    @Pointcut("execution(* com.example.shipment.vtricks.controller.ShipmentController.getAllShipments(..))")
    public void AllShipments(){}
    @Pointcut("execution(* com.example.shipment.vtricks.controller.ShipmentController.generateCsv(..))")
    public void generateCSV(){}

}

