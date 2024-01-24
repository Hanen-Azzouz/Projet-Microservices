package com.example.clinique.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CliniqueDTO {
    public CliniqueDTO(Long id, String nomClinique, String adresse, String telephone) {
        this.id = id;
        this.nomClinique = nomClinique;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    private Long id;
    private String nomClinique;
    private String adresse;
    private String telephone;

    private List<AmbulanceDTO> ambulances;
}
