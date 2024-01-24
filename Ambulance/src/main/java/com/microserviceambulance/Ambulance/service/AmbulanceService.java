package com.microserviceambulance.Ambulance.service;
import java.util.List;

import com.microserviceambulance.Ambulance.DTO.AmbulanceDTO;
import com.microserviceambulance.Ambulance.exception.AmbulanceException;
import com.microserviceambulance.Ambulance.model.Ambulance;


public interface AmbulanceService {

    public List<AmbulanceDTO> getAllAmbulance();

    public List<AmbulanceDTO> getAmbulanceByClinique(int idClinique);

    public AmbulanceDTO getAmbulance(String id) throws AmbulanceException;

    public void createAmbulance(Ambulance ambulance) throws AmbulanceException;

    public void updateAmbulance(String id, Ambulance ambulance) throws AmbulanceException;

    public void deleteAmbulanceById(String id) throws AmbulanceException;

}
