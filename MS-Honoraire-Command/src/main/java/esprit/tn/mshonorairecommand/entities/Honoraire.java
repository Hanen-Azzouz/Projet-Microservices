package esprit.tn.mshonorairecommand.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Honoraire  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idHonoraire;
    LocalDateTime dateHonoraire;
    double montantHonoraire;

}
