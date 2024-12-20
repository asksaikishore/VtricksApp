package com.example.shipment.vtricks.config;

import org.springframework.stereotype.Component;

@Component
public class DynamicRunValue {
    private String dynamicValue;
    private String Dynamicquery;
    public void setDynamicRunId(String str){
        this.dynamicValue=str;
    }
    public String getDynamicRunID(){
        return this.dynamicValue;
    }
    public void setDynamicquery(String str){
        this.Dynamicquery=str;
    }
    public String getDynamicquery(){
        return this.Dynamicquery;
    }
}
