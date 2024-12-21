package com.example.shipment.vtricks.Repository;

import com.example.shipment.vtricks.entity.Run_Value;
import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="Run-app",url = "http://localhost:8082")
@Transactional
public interface Run_Feign {

    @PostMapping("/run/new")
    String CreateRun(Run_Value r);

    @GetMapping("/run/{id}")
    Run_Value getRunById(@PathVariable(value = "id") String Id);
    @PostMapping("/run/updatestatus/{runid}")
     void UpdateStatus(@PathVariable(value = "runid") String runId,@RequestParam(value = "status") String status);

    @DeleteMapping("/run/delete/{runid}")
    void rollBack(@PathVariable(value = "runid") String runID);


}
