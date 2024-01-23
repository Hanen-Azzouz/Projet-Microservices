package com.example.clinique.mapper;

import com.example.clinique.dto.CliniqueDTO;
import com.example.clinique.entity.Clinique;

public class CliniqueMapper {

    public static CliniqueDTO mapToCliniqueDto(Clinique clinique){
        CliniqueDTO cliniqueDto = new CliniqueDTO(
                clinique.getId(),
                clinique.getNomClinique(),
                clinique.getAdresse(),
                clinique.getTelephone()
        );
        return cliniqueDto;
    }

    public static Clinique mapToClinique(CliniqueDTO cliniqueDto){
        Clinique clinique = new Clinique(
                cliniqueDto.getId(),
                cliniqueDto.getNomClinique(),
                cliniqueDto.getAdresse(),
                cliniqueDto.getTelephone()
                );
        return clinique;
    }
}
