package com.example.shipment.vtricks.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.lang.annotation.Documented;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Run_Value {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long run_Id;
    private int Order_ID;
    private String producer_name;
    private Date departure_date;
    private Date arrival_date;
    private String Ship_name;

    @Override
    public String toString() {

        return "Run_Value{" +
                "run_Id=" + run_Id +
                " AND Order_ID=" + Order_ID +
                " AND producer_name='" + producer_name + '\'' +
                " AND departure_date=" + departure_date +
                " AND arrival_date=" + arrival_date +
                " AND Ship_name='" + Ship_name + '\'' +
                '}';
    }

    public Long getRun_Id() {
        return run_Id;
    }

    public Run_Value setRun_Id(Long run_Id) {
        this.run_Id = run_Id;
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
