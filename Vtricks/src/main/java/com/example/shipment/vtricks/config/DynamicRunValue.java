package com.example.shipment.vtricks.config;

import lombok.Synchronized;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class DynamicRunValue {
    private String dynamicValue;
    private String Dynamicquery;
    @Synchronized
    public void setDynamicRunId(String str){
        this.dynamicValue=str;
    }
    public String getDynamicRunID(){
        return this.dynamicValue;
    }
    @Synchronized
    public void setDynamicquery(String str){
        this.Dynamicquery=str;
    }
    public String getDynamicquery(){
        return this.Dynamicquery;
    }
}
