package esprit.tn.medecinservice.dto;

import esprit.tn.medecinservice.entities.Medecin;
import lombok.Builder;

@Builder
public record MedecinDTO(long idMedecin,String nomMedecin,String specialite,int telephone,double prixConsultation) {
  public static Medecin mapToEntity(MedecinDTO medecinDTO){
      return Medecin.builder()
              .idMedecin(medecinDTO.idMedecin)
              .nomMedecin(medecinDTO.nomMedecin)
              .specialite(medecinDTO.specialite)
              .telephone(medecinDTO.telephone)
              .prixConsultation(medecinDTO.prixConsultation)
              .build();
  }

    public static MedecinDTO mapToDTO(Medecin medecin){
      return MedecinDTO.builder()
              .idMedecin(medecin.getIdMedecin())
              .nomMedecin(medecin.getNomMedecin())
              .specialite(medecin.getSpecialite())
              .telephone(medecin.getTelephone())
              .prixConsultation(medecin.getPrixConsultation())
              .build();


    }

}
