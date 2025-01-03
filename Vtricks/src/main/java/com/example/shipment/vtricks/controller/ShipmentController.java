package com.example.shipment.vtricks.controller;
import com.example.shipment.vtricks.Service.ShipServiceImpl;
import com.example.shipment.vtricks.config.DynamicRunValue;
import com.example.shipment.vtricks.entity.Run_Value;
import com.example.shipment.vtricks.entity.Ship;
import com.opencsv.CSVWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
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

    @GetMapping("/csv")
        public ResponseEntity<byte[]> generateCsv() throws IOException,Exception {
            // Sample data to write in CSV
        List<Ship> result = service.getAllShipments();
            List<String[]> csvData = new ArrayList<>();
//        String run_ID=service.createnewRun(new Run_Value());
        String filename="RunId_"+dyn.getDynamicRunID()+"_"+".csv";
            csvData.add(result.get(0).getHeaders());
            for(Ship ship:result){
                csvData.add(ship.values());
            }

            // Write data to ByteArrayOutputStream to send as CSV response
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try (CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(byteArrayOutputStream))) {
                csvWriter.writeAll(csvData); // Write all the data at once
            }


            // Prepare response headers for a CSV download
            HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment; filename="+filename);
        httpHeaders.add("Content-Type", "text/csv");

            return new ResponseEntity<>(byteArrayOutputStream.toByteArray(),httpHeaders, HttpStatus.OK);

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
    @PutMapping("/{id}")
    public ResponseEntity<Ship> updateShip(@PathVariable(value = "id") Long id,@RequestBody Ship ship){
        return ResponseEntity.ok(service.updateRecord(id,ship));
    }





@DeleteMapping("/delete")
public void deleteAll(){
        service.deleterecords();
}


}
