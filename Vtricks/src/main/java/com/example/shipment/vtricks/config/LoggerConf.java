package com.example.shipment.vtricks.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.example.shipment.vtricks"})
@EnableAspectJAutoProxy
public class LoggerConf {

}
