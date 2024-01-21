package com.example.msmedicament.services;

import com.example.msmedicament.dto.RecMedicamentDTO;
import org.springframework.data.domain.Page;

public interface IMedicamentService {
    RecMedicamentDTO addMedicament(RecMedicamentDTO recMedicamentDTO);
    RecMedicamentDTO findById(long id);
    Page<RecMedicamentDTO> findAll(int size, int pagenbr);
    RecMedicamentDTO updateMedicament(RecMedicamentDTO recMedicamentDTO);
    void deleteMedicament(long id);
    void deleteMedicament(RecMedicamentDTO recMedicamentDTO);

}
