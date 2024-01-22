package esprit.tn.honoraireservice.dto;

import esprit.tn.honoraireservice.entities.Honoraire;
import lombok.Builder;

import java.util.Date;

@Builder
public record HonoraireDTO(long idHonoraire, Date dateHonoraire,double montantHonoraire,MedecinDTO medecinDTO) {

    public static Honoraire mapToEntity(HonoraireDTO honoraireDTO){
       return Honoraire.builder()
               .idHonoraire(honoraireDTO.idHonoraire)
               .dateHonoraire(honoraireDTO.dateHonoraire)
               .montantHonoraire(honoraireDTO.montantHonoraire)
               .idMedecin(honoraireDTO.medecinDTO.idMedecin())
               .build();

    }

    public  static HonoraireDTO mapToDTO(Honoraire honoraire){
        return HonoraireDTO.builder()
                .idHonoraire(honoraire.getIdHonoraire())
                .dateHonoraire(honoraire.getDateHonoraire())
                .montantHonoraire(honoraire.getMontantHonoraire())
                .build();

    }


}
