package com.microserviceambulance.Ambulance.service;
import java.util.List;

import com.microserviceambulance.Ambulance.exception.AmbulanceException;
import com.microserviceambulance.Ambulance.model.Ambulance;


public interface AmbulanceService {

    public List<Ambulance> getAllAmbulance();

    public Ambulance getAmbulance(String id) throws AmbulanceException;

    public void createAmbulance(Ambulance ambulance) throws AmbulanceException;

    public void updateAmbulance(String id, Ambulance ambulance) throws AmbulanceException;

    public void deleteAmbulanceById(String id) throws AmbulanceException;
}
