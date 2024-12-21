package com.example.shipment.vtricks.Service;

import com.example.shipment.vtricks.Repository.Run_Feign;
import com.example.shipment.vtricks.Repository.ShipRepo;
import com.example.shipment.vtricks.entity.Run_Value;
import com.example.shipment.vtricks.entity.Ship;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;
//import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class ShipServiceImpl implements ShipService {

Logger logger= LoggerFactory.getLogger("ShipServiceImpl.class");
        @Autowired
    ShipRepo repo;
        @Autowired
        Run_Feign runFeign;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Ship getShipmentsById(Long id) {
        Optional<Ship> result=repo.findById(id);

        return result.isPresent() ? new Ship():result.get();
    }

    @Override
    public List<Ship> getAllShipments() {
        List<Ship> shiplist= repo.findAll();
        long starttime=System.currentTimeMillis();
//        Thread.sleep(6000);

//        if(shiplist.isEmpty()){
//            throw new IOException("input is empty");
//        }
        System.out.println("call complete in  "+(System.currentTimeMillis()-starttime));
        return shiplist;
    }
//    @Async("Get_Shipments_Bean")
    public List<Ship> findShipsByArrivalDate(Date date){

        List<Ship> result=repo.findShipsByArrival_date(date);
        logger.info(result.toString());
        return result;
    }
    public String createnewRun(Run_Value run){
        String runner=runFeign.CreateRun(run);
        System.out.println("ShipService call "+runner);
        return runner;
    }
    public List<Ship> getShipmentByFilters(String str) throws Exception {
        String qry="select k from Ship k where "+str;
        System.out.println("Query = "+qry);
        Query query = entityManager.createQuery(qry, Ship.class);
        Thread.sleep(10000);
//        List<Ship> result=repo.getdata(str);
//        query.setParameter("ask",str);
//        System.out.println("query written = "+query);
//        System.out.println("Service call  "+str);
        List<Ship> result= query.getResultList();
        if(result.isEmpty()){
            throw new Exception("Result is empty");

        }
        return query.getResultList();
    }


    public void updateRunStatus(String runId,String status)  {
//        String runIdstatus=runId+"and"+status;
//        try {
//            runFeign.UpdateStatus(runId,status);
//        }catch(Exception e){
//            logger.info(e.getLocalizedMessage());
//        }
        runFeign.UpdateStatus(runId,status);
    }


    @Override
    @Async("Get_Shipments_Bean")
    public void CreateShipment(Ship ship) {
        repo.save(ship);

    }
    public List<Ship> getSample(){
        System.out.println("service sample called");
        String ss="k.Order_ID = 67";
        return repo.getsample(ss);
    }
    public Run_Value getRunById(String ID){
        return runFeign.getRunById(ID);
    }


//    @Scheduled(fixedRate = 6000)  // runs every 6 seconds
//@Scheduled(cron = "*/4 * * * * *") // runs every 4 seconds format (sec,min,hr,day,month,year)
//    @Scheduled(fixedDelay = 400l)  //runs every 4 seconds
@Async("Get_Shipments_Bean")
    public void RecurringNewShipment(){
        Ship ship=new Ship();
    Date cur=new Date();
        int temp=new Random().nextInt(1,100);
        ship.setShip_name("Titanic_"+(temp % cur.getSeconds())+"");
        ship.setProducer_name("Producer_"+(temp % cur.getMinutes()));
        ship.setOrder_ID(temp);


    ship.setDeparture_date(Calendar.getInstance(TimeZone.getDefault()).getTime());
        ship.setArrival_date(new Date(2025-1900,temp%12,temp%30));
        logger.info("Arrival  Date = "+ship.getArrival_date());
        repo.save(ship);

        logger.info("New Ship inserted: {}"+ship.toString());
    }

//    @Scheduled(fixedRate = 80000)
@Async("Get_Shipments_Bean")
    public void deleterecords(){
logger.info(" records removed:{}","deleted all the records");
    try {
        Thread.sleep(8000l);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    repo.deleteAll();
    }
}
