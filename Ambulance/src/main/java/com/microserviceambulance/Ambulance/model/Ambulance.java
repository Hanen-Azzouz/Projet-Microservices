package com.microserviceambulance.Ambulance.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="ambulance")
public class Ambulance {

    public Ambulance(String id, String matricule, String marque, Long idClinique) {
        this.id = id;
        this.matricule = matricule;
        this.marque = marque;
        this.idClinique = idClinique;
    }

    @Id
    private String id;


    private String matricule;

    private String marque;

    private Date createdAt;

    private Date updatedAt;

    private Long idClinique;
}
