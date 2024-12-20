package com.example.shipment.vtricks.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
import java.util.concurrent.CompletableFuture;

@Entity
@Table(name = "Shipment_Data")
@Data
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int Order_ID;
    private String producer_name;
    private Date departure_date;
    private Date arrival_date;
    private String Ship_name;
    private int Bulk_count;

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", Order_ID=" + Order_ID +
                ", producer_name='" + producer_name + '\'' +
                ", departure_date=" + departure_date +
                ", arrival_date=" + arrival_date +
                ", Ship_name='" + Ship_name + '\'' +
                ", Bulk_count=" + Bulk_count +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Ship setId(Long id) {
        this.id = id;
        return this;
    }

    public int getOrder_ID() {
        return Order_ID;
    }

    public Ship setOrder_ID(int order_ID) {
        Order_ID = order_ID;
        return this;
    }

    public String getProducer_name() {
        return producer_name;
    }

    public Ship setProducer_name(String producer_name) {
        this.producer_name = producer_name;
        return this;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public Ship setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
        return this;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public Ship setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
        return this;
    }

    public String getShip_name() {
        return Ship_name;
    }

    public Ship setShip_name(String ship_name) {
        Ship_name = ship_name;
        return this;
    }

    public int getBulk_count() {
        return Bulk_count;
    }

    public Ship setBulk_count(int bulk_count) {
        Bulk_count = bulk_count;
        return this;
    }
}
