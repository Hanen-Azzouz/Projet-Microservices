package com.microserviceambulance.Ambulance.mapper;

import com.microserviceambulance.Ambulance.DTO.AmbulanceDTO;
import com.microserviceambulance.Ambulance.model.Ambulance;

public class AmbulanceMapper {

    public static AmbulanceDTO mapToAmbulanceDto(Ambulance ambulance){
        AmbulanceDTO ambulanceDto = new AmbulanceDTO(
                ambulance.getId(),
                ambulance.getMatricule(),
                ambulance.getMarque(),
                ambulance.getIdClinique()
        );
        return ambulanceDto;
    }

    public static Ambulance mapToAmbulance(AmbulanceDTO ambulanceDTO){
        Ambulance ambulance = new Ambulance(
                ambulanceDTO.getId(),
                ambulanceDTO.getMatricule(),
                ambulanceDTO.getMarque(),
                ambulanceDTO.getIdClinique()
        );
        return ambulance;
    }
}
