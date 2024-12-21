package com.example.shipment.vtricks.Repository;


import com.example.shipment.vtricks.Service.ShipServiceImpl;
import com.example.shipment.vtricks.entity.Ship;
import jakarta.persistence.QueryHint;
import org.hibernate.annotations.DialectOverride;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface ShipRepo extends JpaRepository<Ship,Long> {
//    public Ship findShipByOrder_ID(int order_Id);

    //    @Query("select ALL from Shipment_Data LIMIT <5>")

    //    @Query("select ALL from Shipment_Data LIMIT <5>")
    @Query(value = "select b from Ship b where b.Order_ID>10")
    public List<Ship> findShipsByArrival_date(Date curdate);

@Query(value = "select * from shipment_data :str2",nativeQuery = true)
    List<Ship> getdata(@Param(value = "str2") String str);

@Query(value = " select k from Ship k  ")
List<Ship> getsample(@Param("str") String sql);
}
