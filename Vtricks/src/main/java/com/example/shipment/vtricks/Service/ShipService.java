package com.example.shipment.vtricks.Service;

import com.example.shipment.vtricks.entity.Ship;

import java.io.IOException;
import java.util.List;
public interface ShipService {


     List<Ship> getAllShipments() throws IOException;
     Ship getShipmentsById(Long id);

     void CreateShipment(Ship ship);
//    public Ship findByOrderID(int order);
}
