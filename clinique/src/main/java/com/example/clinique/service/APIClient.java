package com.example.clinique.service;

import com.example.clinique.dto.AmbulanceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient (name = "microservice-ambulance")
public interface APIClient {
    @GetMapping("http://localhost:9091/ambulances-by-clinique/{idClinique}")
    List<AmbulanceDTO> getAmbulances(@PathVariable("idClinique") long idClinique);
}
