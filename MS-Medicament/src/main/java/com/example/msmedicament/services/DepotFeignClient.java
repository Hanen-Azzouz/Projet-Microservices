package com.example.msmedicament.services;
import com.example.msmedicament.dto.RecDepotDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "MS-DEPOT",url = "http://localhost:9081/")
//@FeignClient(name = "MS-DEPOT")
public interface DepotFeignClient {
    //GET http://localhost:9091/Stocks/findOneDepotById/{{id}}
    @GetMapping("Depots/findOneDepotById/{id}")
    RecDepotDTO findById(@PathVariable String id);

    @PostMapping("Depots/addDepot")
    RecDepotDTO addDepot(@RequestBody RecDepotDTO depotDTO);

}