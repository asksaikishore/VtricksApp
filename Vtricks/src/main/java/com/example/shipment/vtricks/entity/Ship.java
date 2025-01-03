package com.example.shipment.vtricks.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Array;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Shipment_Data")
@Data
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column
    private int Order_ID;
    @Column
    private String producer_name;
    @Column
    private LocalDate departure_date;
    @Column
    private LocalDate arrival_date;
    @Column
    private String Ship_name;
    @Column
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

    @JsonIgnore
    public String[] values(){
        List<String> list=new ArrayList<>();
        if(id!=null){
            list.add(String.valueOf(id));
        }
        if(Order_ID!=0){
            list.add(String.valueOf(Order_ID));
        }
        if(producer_name!=null){
            list.add(producer_name);

        }
        if(departure_date!=null){
            list.add(String.valueOf(departure_date));
        }
        if(arrival_date!=null){
            list.add(String.valueOf(arrival_date));
        }
        if(Ship_name!=null){
            list.add(Ship_name);

        }

        return list.toArray(String[]::new);
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

    public LocalDate getDeparture_date() {
        return departure_date;
    }

    public Ship setDeparture_date(LocalDate departure_date) {
        this.departure_date = departure_date;
        return this;
    }

    public LocalDate getArrival_date() {
        return arrival_date;
    }

    public Ship setArrival_date(LocalDate arrival_date) {
        this.arrival_date =arrival_date;
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
    @JsonIgnore
    public String[] getHeaders(){
        List<String> list=new ArrayList<>();
        if(id!=null){
            list.add("runId");
        }
        if(Order_ID!=0){
            list.add("Order_ID");
        }
        if(producer_name!=null){
            list.add("producer_name");

        }
        if(departure_date!=null){
            list.add("departure_date");
        }
        if(arrival_date!=null){
            list.add("arrival_date");
        }
        if(Ship_name!=null){
            list.add("Ship_name");

        }

        return list.toArray(String[]::new);
    }
}
