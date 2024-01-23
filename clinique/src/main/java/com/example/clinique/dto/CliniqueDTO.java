package com.example.clinique.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CliniqueDTO {
    private Long id;
    private String nomClinique;
    private String adresse;
    private String telephone;
}
