package com.example.shipment.vtricks;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class ShipmentDTO {

    private Long id;
    private int Order_ID;
    private String producer_name;
    private LocalDate departure_date;
    private LocalDate arrival_date;
    private String Ship_name;
    private int Bulk_count;
}
