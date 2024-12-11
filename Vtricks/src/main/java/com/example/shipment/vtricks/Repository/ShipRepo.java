package com.example.shipment.vtricks.Repository;


import com.example.shipment.vtricks.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ShipRepo extends JpaRepository<Ship,Long> {
//    public Ship findShipByOrder_ID(int order_Id);

//    @Query("select ALL from Shipment_Data LIMIT <5>")
//    public List<Ship> gettopFiveRecords();
}
