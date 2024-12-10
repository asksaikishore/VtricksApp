package com.example.shipment.vtricks.Service;

import com.example.shipment.vtricks.entity.Ship;

import java.io.IOException;
import java.util.List;
public interface ShipService {


    public List<Ship> getAllShipments() throws IOException;
    public Ship getShipmentsById(Long id);

    public void CreateShipment(Ship ship);
//    public Ship findByOrderID(int order);
}
