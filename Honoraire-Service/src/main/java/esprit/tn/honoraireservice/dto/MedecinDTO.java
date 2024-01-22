package esprit.tn.honoraireservice.dto;

import lombok.Builder;

@Builder
public record MedecinDTO(long idMedecin,String nomMedecin,String specialite,int telephone,double prixConsultation ) {
}
