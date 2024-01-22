package esprit.tn.medecinservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "medecin")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medecin implements Serializable {
    @Id
    long idMedecin;
    String nomMedecin;
    String specialite;
    int telephone;
    double prixConsultation;

}
