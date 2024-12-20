package com.example.shipment.vtricks;

import com.example.shipment.vtricks.AOP.LoggingConfig;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
@Aspect
public class VtricksApplication {

    public static void main(String[] args) {


       ConfigurableApplicationContext ac= SpringApplication.run(VtricksApplication.class, args);
//       LoggingConfig lc = ac.getBean(LoggingConfig.class);

//       lc.beforeController(lc.jp);
    }

}
