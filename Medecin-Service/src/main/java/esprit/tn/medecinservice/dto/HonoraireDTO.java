package esprit.tn.medecinservice.dto;

import lombok.Builder;

import java.util.Date;
@Builder
public record HonoraireDTO(long idHonoraire, Date dateHonoraire, double montantHonoraire, MedecinDTO medecinDTO) {
}
