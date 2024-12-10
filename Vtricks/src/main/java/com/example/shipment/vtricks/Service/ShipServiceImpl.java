package com.example.shipment.vtricks.Service;

import com.example.shipment.vtricks.Repository.ShipRepo;
import com.example.shipment.vtricks.entity.Ship;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
public class ShipServiceImpl implements ShipService {

Logger logger= LoggerFactory.getLogger("ShipServiceImpl.class");
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
        Ship shipList1=repo.findById(id).orElse(new Ship());


        return shipList1;
    }
    @Override
    public void CreateShipment(Ship ship) {
        repo.save(ship);

    }
    @Scheduled(fixedRate = 6000)
    public void RecurringNewShipment(){
        Ship ship=new Ship();
        ship.setShip_name("Titanic "+(new Random().nextInt(1,100))+"");
        repo.save(ship);
        logger.info("New Ship inserted: {}"+ship.toString());
    }

    @Scheduled(fixedRate = 20000)
    public void deleterecords(){
logger.info(" records removed:{}","deleted all the records");
        repo.deleteAll();
    }


}
