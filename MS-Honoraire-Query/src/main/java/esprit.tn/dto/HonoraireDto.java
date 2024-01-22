package esprit.tn.dto;


import esprit.tn.mshonorairequery.entities.Honoraire;

import java.time.LocalDateTime;


public record HonoraireDto(long idHonoraire, LocalDateTime dateHonoraire, double montantHonoraire) {


    public static Honoraire mapToEntity(HonoraireDto honoraireDto){


        return new Honoraire(honoraireDto.idHonoraire(),honoraireDto.dateHonoraire(),honoraireDto.montantHonoraire());
    }
    public static HonoraireDto mapToDTO(Honoraire honoraire){

        return new HonoraireDto(honoraire.getIdHonoraire(),honoraire.getDateHonoraire(), honoraire.getMontantHonoraire());
    }









}
