package com.example.msdepot.services;

import com.example.msdepot.dto.RecDepotDTO;
import org.springframework.data.domain.Page;

public interface IDepotService {
    RecDepotDTO addDepot(RecDepotDTO depotDTO);
    RecDepotDTO findById(String id);
    Page<RecDepotDTO> findAll(int size, int pagenbr);
    RecDepotDTO updateDepot(RecDepotDTO depotDTO);
    void deleteDepot(String id);
    void deleteDepot(RecDepotDTO depotDTO);

}
