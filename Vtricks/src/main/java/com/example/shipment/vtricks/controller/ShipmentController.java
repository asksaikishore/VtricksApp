package com.example.shipment.vtricks.controller;

import com.example.shipment.vtricks.Service.ShipServiceImpl;
import com.example.shipment.vtricks.entity.Ship;
import org.bouncycastle.internal.asn1.iso.ISOIECObjectIdentifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/shipment")
@Slf4j
public class ShipmentController {
//    Logger logger=LoggerFactory.getLogger(ShipmentController.class);

    @Autowired
    ShipServiceImpl service;

    @GetMapping("/all")
    public ResponseEntity<List<Ship>> getAllShipments() throws Exception {

        System.out.println("in bound");
        return new ResponseEntity<>(service.getAllShipments(),HttpStatus.OK);

    }
    @GetMapping("/all/ArrivalDate")
    public ResponseEntity<List<Ship>> getAllShipmentsBydate(@RequestParam String ArrivalDate ){
        List<Ship> result;
//        logger.info("Received Date is "+ArrivalDate);
        Date d=new Date(ArrivalDate);
        System.out.println(" date printed"+ArrivalDate);
//        logger.info("Received Date is "+d);
        result=service.findShipsByArrivalDate(d);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ship> getShipByID(@PathVariable Long id){


        return new ResponseEntity<>(service.getShipmentsById(id),HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<String> CreateNewShipment(@RequestBody Ship ship){

        service.CreateShipment(ship);
        return new ResponseEntity<>("new Shipment Created",HttpStatus.CREATED);
    }

//    public ResponseEntity<String>




}
