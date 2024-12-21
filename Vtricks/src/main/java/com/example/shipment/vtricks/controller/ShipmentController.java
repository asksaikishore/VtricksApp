package com.example.shipment.vtricks.controller;
import com.example.shipment.vtricks.Service.ShipServiceImpl;
import com.example.shipment.vtricks.config.DynamicRunValue;
import com.example.shipment.vtricks.entity.Ship;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @Autowired
    DynamicRunValue dyn;

    @GetMapping("/all")
    public ResponseEntity<List<Ship>> getAllShipments(
            @RequestParam(value = "OrderID",required = false) Integer OrderID,
            @RequestParam(value = "producer_name",required = false) String producer_name,
            @RequestParam(value = "Ship_name",required = false) String Ship_name
    ) throws Exception {
//        String InputQuery=service.getRunById(dyn.getDynamicRunID()).getArgs();
//        System.out.println("get status by run ID "+InputQuery);
        System.out.println("Global Run ID created = "+dyn.getDynamicRunID());
        System.out.println("Global Run Query generated = "+dyn.getDynamicquery());
        List<Ship> result=new ArrayList<>();
try {
 result = service.getShipmentByFilters(dyn.getDynamicquery());
// Thread.sleep(4000);

}catch(Exception e){
service.updateRunStatus(dyn.getDynamicRunID(),"Failure");

}


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
