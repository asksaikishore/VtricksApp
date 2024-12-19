package com.example.shipment.vtricks.entity;



import org.springframework.data.annotation.Id;

import java.util.Date;

public class Run_Value {
    @Id
    private String runId;
    private int Order_ID;
    private String producer_name;
    private Date departure_date;
    private Date arrival_date;
    private String Ship_name;


    @Override
    public String toString() {
        return "Run_Value{" +
                "runId='" + runId + '\'' +
                ", Order_ID=" + Order_ID +
                ", producer_name='" + producer_name + '\'' +
                ", departure_date=" + departure_date +
                ", arrival_date=" + arrival_date +
                ", Ship_name='" + Ship_name + '\'' +
                '}';
    }

    public String getRunId() {
        return runId;
    }

    public Run_Value setRunId(String runId) {
        this.runId = runId;
        return this;
    }

    public int getOrder_ID() {
        return Order_ID;
    }

    public Run_Value setOrder_ID(int order_ID) {
        Order_ID = order_ID;
        return this;
    }

    public String getProducer_name() {
        return producer_name;
    }

    public Run_Value setProducer_name(String producer_name) {
        this.producer_name = producer_name;
        return this;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public Run_Value setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
        return this;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public Run_Value setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
        return this;
    }

    public String getShip_name() {
        return Ship_name;
    }

    public Run_Value setShip_name(String ship_name) {
        Ship_name = ship_name;
        return this;
    }
}