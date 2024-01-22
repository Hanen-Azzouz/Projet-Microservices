package com.example.msdepot.services;

import com.example.msdepot.dto.RecDepotDTO;
import com.example.msdepot.entities.Depot;
import com.example.msdepot.repositories.DepotRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepotService implements IDepotService{
    private final DepotRepo depotRepo;


    @Override
    public RecDepotDTO addDepot(RecDepotDTO depotDTO) {
        Depot depot=depotRepo.save(depotDTO.mapToEntity(depotDTO));
        return depotDTO.mapToDTO(depot);
    }

    @Override
    public RecDepotDTO findById(String id) {
        Depot depot=depotRepo.findById(id).orElseThrow(()->new IllegalArgumentException("No Stock found with this id" + id));
        return RecDepotDTO.mapToDTO(depot);
    }

    @Override
    public Page<RecDepotDTO> findAll(int size, int pagenbr) {
        return depotRepo.findAll(PageRequest.of(pagenbr,size)).map(RecDepotDTO::mapToDTO);
    }

    @Override
    public RecDepotDTO updateDepot(RecDepotDTO depotDTO) {
        Depot depot=depotRepo.save((depotDTO.mapToEntity(depotDTO)));
        return depotDTO.mapToDTO(depot);
    }

    @Override
    public void deleteDepot(String id) {
        depotRepo.deleteById(id);

    }

    @Override
    public void deleteDepot(RecDepotDTO depotDTO) {
        depotRepo.delete(depotDTO.mapToEntity(depotDTO));

    }
}
