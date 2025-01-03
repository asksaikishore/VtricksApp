package com.example.shipment.vtricks.Service;

import com.example.shipment.vtricks.entity.Ship;

import java.util.List;

public interface ShipService {


     List<Ship> getAllShipments() throws Exception;
     Ship getShipmentsById(Long id);

     void CreateShipment(Ship ship);
//    public Ship findByOrderID(int order);
}
