package com.example.shipment.vtricks.Repository;


import com.example.shipment.vtricks.entity.Ship;
import org.hibernate.annotations.DialectOverride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface ShipRepo extends JpaRepository<Ship,Long> {
//    public Ship findShipByOrder_ID(int order_Id);

    //    @Query("select ALL from Shipment_Data LIMIT <5>")

    //    @Query("select ALL from Shipment_Data LIMIT <5>")
    @Query(value = "select * from shipment_data where arrival_date < ?1",nativeQuery = true)
    public List<Ship> findShipsByArrival_date(Date curdate);
}
