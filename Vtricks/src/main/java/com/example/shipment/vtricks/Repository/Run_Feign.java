package com.example.shipment.vtricks.Repository;

import com.example.shipment.vtricks.entity.Run_Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="Run-app",url = "http://localhost:8082")
public interface Run_Feign {

    @PostMapping("/run/new")
    Run_Value CreateRun(Run_Value r);

    @GetMapping("/run/{id}")
    Run_Value getRunById(@PathVariable(value = "id") Long Id);


}
