package com.example.shipment.vtricks.Service;

import com.example.shipment.vtricks.Repository.ShipRepo;
import com.example.shipment.vtricks.entity.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ShipServiceImpl implements ShipService {
    @Autowired
    ShipRepo repo;

    @Override
    public List<Ship> getAllShipments() throws IOException {
        List<Ship> shiplist=repo.findAll();

        if(shiplist.isEmpty()){
            throw new IOException("input is empty");
        }

        return shiplist;
    }

    @Override
    public Ship getShipmentsById(Long id) {
        Optional<Ship> shipList1=repo.findById(id);


        return shipList1.isPresent() ? shipList1.get() : new Ship();
    }

    @Override
    public void CreateShipment(Ship ship) {
        Ship ship1=repo.save(ship);

    }
}
