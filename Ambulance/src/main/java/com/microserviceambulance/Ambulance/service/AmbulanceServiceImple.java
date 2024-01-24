package com.microserviceambulance.Ambulance.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.microserviceambulance.Ambulance.DTO.AmbulanceDTO;
import com.microserviceambulance.Ambulance.exception.AmbulanceException;
import com.microserviceambulance.Ambulance.mapper.AmbulanceMapper;
import com.microserviceambulance.Ambulance.model.Ambulance;
import com.microserviceambulance.Ambulance.repository.AmbulanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component
public class AmbulanceServiceImple implements AmbulanceService {


    @Autowired
    private AmbulanceRepository ambulanceRepo;


    @Override
    public List<AmbulanceDTO> getAllAmbulance() {
        List<Ambulance> ambulances = ambulanceRepo.findAll();
        List<AmbulanceDTO> ambulancesDto= new ArrayList<>();
        if (ambulances.size() > 0) {
            for (Ambulance ambulance : ambulances) {
                AmbulanceDTO dto =AmbulanceMapper.mapToAmbulanceDto(ambulance);
                ambulancesDto.add(dto);
            }
            return ambulancesDto;
        }else {
            return new ArrayList<AmbulanceDTO>();
        }
    }

    @Override
    public List<AmbulanceDTO> getAmbulanceByClinique(int idClinique) {
        List<Ambulance> ambulances = ambulanceRepo.findByClinique(idClinique);
        List<AmbulanceDTO> ambulancesDto= new ArrayList<>();
        if (ambulances.size() > 0) {
            for (Ambulance ambulance : ambulances) {
                AmbulanceDTO dto =AmbulanceMapper.mapToAmbulanceDto(ambulance);
                ambulancesDto.add(dto);
            }
            return ambulancesDto;
        }else {
            return new ArrayList<AmbulanceDTO>();
        }
    }

    @Override
    public AmbulanceDTO getAmbulance(String id) throws AmbulanceException {
        Optional<Ambulance> ambulanceOptional = ambulanceRepo.findById(id);
        if (!ambulanceOptional.isPresent()) {
            throw new AmbulanceException(AmbulanceException.NotFoundException(id));
        }else {
            return AmbulanceMapper.mapToAmbulanceDto(ambulanceOptional.get());
        }
    }

    @Override
    public void createAmbulance(Ambulance todo) throws AmbulanceException{

            todo.setCreatedAt(new Date(System.currentTimeMillis()));
            ambulanceRepo.save(todo);


    }

    @Override
    public void updateAmbulance(String id, Ambulance todo) throws AmbulanceException{
        Optional<Ambulance> todoWithId = ambulanceRepo.findById(id);
        Optional<Ambulance> todoWithSameName = ambulanceRepo.findByMatricule(todo.getMatricule());
        if(todoWithId.isPresent())
        {
            if(todoWithSameName.isPresent() && !todoWithSameName.get().getId().equals(id))
            {

                throw new AmbulanceException(AmbulanceException.AmbulanceAlreadyExists());
            }
            Ambulance todoToUpdate=todoWithId.get();

            todoToUpdate.setMatricule(todo.getMatricule());
            todoToUpdate.setMarque(todo.getMarque());
            todoToUpdate.setUpdatedAt(new Date(System.currentTimeMillis()));
            ambulanceRepo.save(todoToUpdate);
        }
        else
        {
            throw new AmbulanceException(AmbulanceException.NotFoundException(id));
        }
    }

    @Override
    public void deleteAmbulanceById(String id) throws AmbulanceException {
        Optional<Ambulance> todoOptional = ambulanceRepo.findById(id);
        if (!todoOptional.isPresent()) {
            throw new AmbulanceException(AmbulanceException.NotFoundException(id));
        } else {
            ambulanceRepo.deleteById(id);
        }
    }

}
