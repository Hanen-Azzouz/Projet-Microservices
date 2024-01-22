package com.example.msdepot.dto;
import com.example.msdepot.entities.Depot;
import lombok.Builder;

@Builder
public record RecDepotDTO(String id, String name, String emplacement) {

    public static Depot mapToEntity(RecDepotDTO depotDTO){
        return Depot.builder()
                .idDepot(depotDTO.id)
                .nomDepot(depotDTO.name)
                .emplacement(depotDTO.emplacement)
                .build();

    }

    public static RecDepotDTO mapToDTO(Depot depot){
        return RecDepotDTO.builder()
                .id(depot.getIdDepot())
                .name(depot.getNomDepot())
                .emplacement(depot.getEmplacement())
                .build();

    }
}