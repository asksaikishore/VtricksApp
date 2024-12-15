package com.example.shipment.vtricks.Service;

import com.example.shipment.vtricks.Repository.ShipRepo;
import com.example.shipment.vtricks.entity.Ship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
@Slf4j
public class ShipServiceImpl implements ShipService {

Logger logger= LoggerFactory.getLogger("ShipServiceImpl.class");
        @Autowired
    ShipRepo repo;

//Thread thead=new Thread(t);
    @Override
    public Ship getShipmentsById(Long id) {
        Ship shipList1=repo.findById(id).orElse(new Ship());


        return shipList1;
    }

    @Override

    public List<Ship> getAllShipments() throws Exception {
        List<Ship> shiplist=repo.findAll();
        long starttime=System.currentTimeMillis();
        Thread.sleep(6000);

        if(shiplist.isEmpty()){
            throw new IOException("input is empty");
        }
        System.out.println("call complete in  "+(System.currentTimeMillis()-starttime));
        return shiplist;
    }

    public List<Ship> findShipsByArrivalDate(Date date){
        return new ArrayList<>(repo.findShipsByArrival_date(date));
    }


    @Override
    public void CreateShipment(Ship ship) {
        repo.save(ship);

    }
//    @Scheduled(fixedRate = 6000)
    public void RecurringNewShipment(){
        Ship ship=new Ship();
        int temp=new Random().nextInt(1,100);
        ship.setShip_name("Titanic "+(temp)+"");
        Date cur=new Date();

        ship.setDeparture_date(Calendar.getInstance(TimeZone.getDefault()).getTime());
        ship.setArrival_date(new Date(2025-1900,temp%12,temp%30));
        logger.info("Arrival  Date = "+ship.getArrival_date());
        repo.save(ship);

        logger.info("New Ship inserted: {}"+ship.toString());
    }

//    @Scheduled(fixedRate = 80000)
    public void deleterecords(){
logger.info(" records removed:{}","deleted all the records");
        repo.deleteAll();
    }
}
