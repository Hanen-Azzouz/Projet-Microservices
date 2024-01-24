package com.microserviceambulance.Ambulance.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AmbulanceDTO {
    private String id;
    private String matricule;
    private String marque;
    private Long idClinique;

}
