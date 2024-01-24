package com.example.clinique.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
