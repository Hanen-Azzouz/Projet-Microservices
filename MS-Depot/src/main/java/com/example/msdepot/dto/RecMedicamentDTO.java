package com.example.msdepot.dto;

import lombok.Builder;

@Builder
public record RecMedicamentDTO(long id, String name, RecDepotDTO depotDTO) {
}
