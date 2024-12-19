package com.example.shipment.vtricks.controller;

import com.example.shipment.vtricks.Service.ShipServiceImpl;
import com.example.shipment.vtricks.entity.Run_Value;
import com.example.shipment.vtricks.entity.Ship;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/shipment")
@Slf4j
public class ShipmentController {
//    Logger logger=LoggerFactory.getLogger(ShipmentController.class);

    @Autowired
    ShipServiceImpl service;

    @GetMapping("/all")
    public ResponseEntity<List<Ship>> getAllShipments(
            @RequestParam(required = false) Integer OrderID,
            @RequestParam(required = false) String producer_name,
            @RequestParam(required = false) String Ship_name
    ) throws Exception {
        List<String> input=new ArrayList<>();
        Run_Value run=new Run_Value();
        run.setOrder_ID(OrderID);
        run.setProducer_name(producer_name);
        run.setShip_name(Ship_name);
        Long newRunId= service.createnewRun(run).getRun_Id();
        if(OrderID!=null){
            input.add("k.Order_ID ="+OrderID);
        }
        if(producer_name!=null){
            input.add("k.producer_name ="+producer_name);
        }
        if(Ship_name!=null){
            input.add("k.Ship_name ='"+Ship_name+"'");
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<input.size();i++){
            if(i!=0){
                sb.append(" AND ");
                sb.append(input.get(i));

            }else{
                sb.append(input.get(i));
            }
        }
        if(sb.isEmpty()){
            sb.append("k.Id >=0");}
        System.out.println(sb.toString());
        List<Ship> result=service.getShipmentByFilters(sb.toString());


//        List<Ship> result=service.getAllShipments();

        System.out.println("in bound");
        return new ResponseEntity<>(result,HttpStatus.OK);

    }

    @GetMapping("/all/Arrival")
    public ResponseEntity<List<Ship>> getAllShipmentsBydate(@RequestParam String ArrivalDate ){
        Date d=new Date(ArrivalDate);

//        logger.info("Received Date is "+ArrivalDate);

        System.out.println(" date printed"+ArrivalDate);
//        logger.info("Received Date is "+d);
        List<Ship> result=service.findShipsByArrivalDate(d);

//        return ResponseEntity.ok(result);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ship> getShipByID(@PathVariable(value = "id") Long id)  {
        Ship sh= service.getShipmentsById(id);

        return new ResponseEntity<>(sh,HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<String> CreateNewShipment(@RequestBody Ship ship){

        service.CreateShipment(ship);
        return new ResponseEntity<>("new Shipment Created",HttpStatus.CREATED);
    }

    @GetMapping("/reccur")
    public ResponseEntity<String> reccurCreateDestroy(){
        service.RecurringNewShipment();
//        service.deleterecords();
        return ResponseEntity.ok("reccuring");
    }

    @GetMapping("/sample")
    public ResponseEntity<List<Ship>> getSample(){

        return ResponseEntity.ok(service.getSample());
    }





@DeleteMapping("/delete")
public void deleteAll(){
        service.deleterecords();
}


}
