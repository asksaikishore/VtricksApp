package com.example.shipment.vtricks.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Entity
@Table(name = "Shipment_Data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int Order_ID;
    @NonNull
    private int producer_name;
    private Date departure_date;

    private Date arrival_date;
    private String Ship_name;
    private int Bulk_count;




}
