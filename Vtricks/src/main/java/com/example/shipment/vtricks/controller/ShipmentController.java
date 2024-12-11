package com.example.shipment.vtricks.controller;

import com.example.shipment.vtricks.Service.ShipServiceImpl;
import com.example.shipment.vtricks.entity.Ship;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/shipment")
@Slf4j
public class ShipmentController {


    @Autowired
    ShipServiceImpl service;

    @GetMapping("/all")
    public ResponseEntity<List<Ship>> getAllShipments() throws IOException {


        return new ResponseEntity<>(service.getAllShipments(),HttpStatus.OK);

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
