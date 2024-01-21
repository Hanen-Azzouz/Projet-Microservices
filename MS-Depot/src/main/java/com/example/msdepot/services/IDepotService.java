package com.example.msdepot.services;

import com.example.msdepot.dto.RecDepotDTO;
import org.springframework.data.domain.Page;

public interface IDepotService {
    RecDepotDTO addDepot(RecDepotDTO depotDTO);
    RecDepotDTO findById(long id);
    Page<RecDepotDTO> findAll(int size, int pagenbr);
    RecDepotDTO updateDepot(RecDepotDTO depotDTO);
    void deleteDepot(long id);
    void deleteDepot(RecDepotDTO depotDTO);

}
