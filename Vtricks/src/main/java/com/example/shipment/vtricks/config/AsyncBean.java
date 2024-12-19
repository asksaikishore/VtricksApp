package com.example.shipment.vtricks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@EnableAsync(proxyTargetClass = true)
public class AsyncBean {

@Bean("Get_Shipments_Bean")
    public Executor ExecService(){

    ThreadPoolTaskExecutor tp=new ThreadPoolTaskExecutor();
    tp.setCorePoolSize(5);
    tp.setQueueCapacity(150);
    tp.setThreadNamePrefix("My_Async_Bean");
    tp.initialize();
    return tp;

    }

}
