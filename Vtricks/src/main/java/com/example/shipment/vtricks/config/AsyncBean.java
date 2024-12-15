package com.example.shipment.vtricks.config;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Async(" Bean of Async type called")
public class AsyncBean {

}
