package com.example.msmedicament.entities;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
@Document
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Medicament implements Serializable {
    @Id
    @Setter(AccessLevel.NONE)
    long idMedicament;
    String nomMedicament;
    Date dateExpiration;
    long idDepot;
}
