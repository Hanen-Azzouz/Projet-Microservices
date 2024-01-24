package com.microserviceambulance.Ambulance.controller;

import com.microserviceambulance.Ambulance.DTO.AmbulanceDTO;
import com.microserviceambulance.Ambulance.exception.AmbulanceException;
import com.microserviceambulance.Ambulance.model.Ambulance;
import com.microserviceambulance.Ambulance.service.AmbulanceService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AmbulanceController {

    @Autowired(required = true)
    private AmbulanceService ambulanceService;

    @PostMapping("/ambulance")
    public ResponseEntity<?> createAmbulance(@RequestBody Ambulance ambulance) {
        try {
            ambulanceService.createAmbulance(ambulance);
            return new ResponseEntity<Ambulance>(ambulance, HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (AmbulanceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/ambulances")
    public ResponseEntity<?> getAllAmbulance() {
        List<AmbulanceDTO> ambulance = ambulanceService.getAllAmbulance();
        return new ResponseEntity<>(ambulance, ambulance.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/ambulances/{id}")
    public ResponseEntity<?> getSingleAmbulance(@PathVariable("id") String id){
        try {
            return new ResponseEntity<>(ambulanceService.getAmbulance(id), HttpStatus.OK);
        } catch (AmbulanceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/ambulances/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) throws AmbulanceException{
        try{
            ambulanceService.deleteAmbulanceById(id);
            return new ResponseEntity<>("Successfully deleted ambulance with id "+id, HttpStatus.OK);
        }
        catch (AmbulanceException e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/ambulances/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody Ambulance ambulance)
    {
        try {
            ambulanceService.updateAmbulance(id,ambulance);
            return new ResponseEntity<>("Updated movie with id "+id+"", HttpStatus.OK);
        }
        catch(ConstraintViolationException e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        catch (AmbulanceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/ambulances-by-clinique/{id}")
    public ResponseEntity<?> getAmbulanceByclinique(@PathVariable("id") int idClinique){
        List<AmbulanceDTO> ambulance = ambulanceService.getAmbulanceByClinique(idClinique);
        return new ResponseEntity<>(ambulance, ambulance.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
@GetMapping("/khalil")
public String khalil() {

    return "khalil";
}
}
