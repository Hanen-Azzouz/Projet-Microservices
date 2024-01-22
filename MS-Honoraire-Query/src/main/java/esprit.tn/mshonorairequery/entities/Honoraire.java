package esprit.tn.mshonorairequery.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Document
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Honoraire  implements Serializable {
    @Id
    @Setter(AccessLevel.NONE)
    long idHonoraire;
    LocalDateTime dateHonoraire;
    double montantHonoraire;

}
