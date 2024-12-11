package com.example.shipment.vtricks.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Entity
@Table(name = "Shipment_Data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int Order_ID;
    private String producer_name;
    private Date departure_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(int order_ID) {
        Order_ID = order_ID;
    }

    public String getProducer_name() {
        return producer_name;
    }

    public void setProducer_name(String producer_name) {
        this.producer_name = producer_name;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getShip_name() {
        return Ship_name;
    }

    public void setShip_name(String ship_name) {
        Ship_name = ship_name;
    }

    public int getBulk_count() {
        return Bulk_count;
    }

    public void setBulk_count(int bulk_count) {
        Bulk_count = bulk_count;
    }

    private Date arrival_date;
    private String Ship_name;
    private int Bulk_count;




}
