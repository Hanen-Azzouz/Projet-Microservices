package com.example.clinique.service;

import com.example.clinique.Exception.CliniqueException;
import com.example.clinique.Repository.CliniqueRepository;
import com.example.clinique.dto.CliniqueDTO;
import com.example.clinique.entity.Clinique;
import com.example.clinique.mapper.CliniqueMapper;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CliniqueServiceImple implements CliniqueService{
    private static final Logger LOGGER = LoggerFactory.getLogger(CliniqueServiceImple.class);

    private CliniqueRepository cliniqueRepository;

    @Override
    public CliniqueDTO saveClinique(CliniqueDTO cliniqueDto) {
        Clinique clinique = CliniqueMapper.mapToClinique(cliniqueDto);
        Clinique savedClinique = cliniqueRepository.save(clinique);
        CliniqueDTO savedCliniqueDto = CliniqueMapper.mapToCliniqueDto(savedClinique);
        return savedCliniqueDto;
    }

    @Override
    public List<CliniqueDTO> getAllClinique() {
        List<Clinique> cliniques = cliniqueRepository.findAll();
        List<CliniqueDTO> clinquesDto= new ArrayList<>();
        if (cliniques.size() > 0) {
            for (Clinique clinique : cliniques) {
                CliniqueDTO dto =CliniqueMapper.mapToCliniqueDto(clinique);
                clinquesDto.add(dto);
            }
            return clinquesDto;
        }else {
            return new ArrayList<CliniqueDTO>();
        }
    }

    @Override
    public void deleteClinique(Long id) throws CliniqueException{
        Optional<Clinique> cliniqueOptional = cliniqueRepository.findById(id);
        if (!cliniqueOptional.isPresent()) {
            throw new CliniqueException(CliniqueException.NotFoundException(id));
        } else {
            cliniqueRepository.deleteById(id);
        }

    }

    @Override
    public CliniqueDTO getClinique(Long cliniqueId) throws CliniqueException{
        Optional<Clinique> cliniqueOptional = cliniqueRepository.findById(cliniqueId);
        if (!cliniqueOptional.isPresent()) {
            throw new CliniqueException(CliniqueException.NotFoundException(cliniqueId));
        }else {
            return  CliniqueMapper.mapToCliniqueDto(cliniqueOptional.get()) ;
        }
    }

    @Override
    public void updateClinique(Long id, Clinique clinique) throws CliniqueException {
        Optional<Clinique> cliniqueWithId = cliniqueRepository.findById(id);

        if(cliniqueWithId.isPresent())
        {
            Clinique cliniqueToUpdate=cliniqueWithId.get();
            cliniqueToUpdate.setNomClinique(clinique.getNomClinique());
            cliniqueToUpdate.setAdresse(clinique.getAdresse());
            cliniqueToUpdate.setTelephone(clinique.getTelephone());
            cliniqueRepository.save(cliniqueToUpdate);
        }
        else
        {
            throw new CliniqueException(CliniqueException.NotFoundException(id));
        }
    }

}
