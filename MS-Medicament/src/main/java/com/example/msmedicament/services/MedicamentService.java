package com.example.msmedicament.services;
import com.example.msmedicament.dto.RecDepotDTO;
import com.example.msmedicament.dto.RecMedicamentDTO;
import com.example.msmedicament.entities.Medicament;
import com.example.msmedicament.repositories.MedicamentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class MedicamentService implements IMedicamentService {

    private final MedicamentRepo medicamentRepo;
    private final DepotFeignClient feignDepotService;

    @Override
    public RecMedicamentDTO addMedicament(RecMedicamentDTO recMedicamentDTO) {
        Medicament medicament=medicamentRepo.save(recMedicamentDTO.mapToEntity(recMedicamentDTO));
        RecDepotDTO depot=recMedicamentDTO.recDepotDTO();
        feignDepotService.addDepot(depot);
        return recMedicamentDTO.mapToDTO(medicament);
    }

    @Override
    public RecMedicamentDTO findById(long id) {
        Medicament medicament=medicamentRepo.findById(id).orElseThrow(()->new IllegalArgumentException("No Medicament found with this id"));
        String depotId = medicament.getIdDepot();
        RecDepotDTO recDepotDTO = feignDepotService.findById(depotId);

        RecMedicamentDTO recMedicamentDTO =new RecMedicamentDTO(
                medicament.getIdMedicament(),medicament.getNomMedicament(),medicament.getDateExpiration(), recDepotDTO
        );
        return recMedicamentDTO ;
    }

    @Override
    public Page<RecMedicamentDTO> findAll(int size, int pagenbr) {
        return medicamentRepo.findAll(PageRequest.of(pagenbr,size)).map(RecMedicamentDTO::mapToDTO);
    }

    @Override
    public RecMedicamentDTO updateMedicament(RecMedicamentDTO recMedicamentDTO) {
        Medicament medicament=medicamentRepo.save(recMedicamentDTO.mapToEntity(recMedicamentDTO));
        return recMedicamentDTO.mapToDTO(medicament);
    }

    @Override
    public void deleteMedicament(long id) {
        medicamentRepo.deleteById(id);
    }

    @Override
    public void deleteMedicament(RecMedicamentDTO recMedicamentDTO) {
        medicamentRepo.delete(recMedicamentDTO.mapToEntity(recMedicamentDTO));
    }
}