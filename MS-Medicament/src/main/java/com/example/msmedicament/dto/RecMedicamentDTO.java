package com.example.msmedicament.dto;

import com.example.msmedicament.entities.Medicament;
import lombok.Builder;

import java.util.Date;

@Builder
public record RecMedicamentDTO(long id, String name, Date dateexp, RecDepotDTO recDepotDTO) {
    public static Medicament mapToEntity(RecMedicamentDTO recMedicamentDTO){
        return Medicament.builder()
                .idMedicament(recMedicamentDTO.id)
                .nomMedicament(recMedicamentDTO.name)
                .dateExpiration(recMedicamentDTO.dateexp)
                .idDepot(recMedicamentDTO.recDepotDTO().id())
                .build();

    }

    public static RecMedicamentDTO mapToDTO(Medicament medicament){
        return RecMedicamentDTO.builder()
                .id(medicament.getIdMedicament())
                .name(medicament.getNomMedicament())
                .dateexp(medicament.getDateExpiration())
                .build();

    }

}
