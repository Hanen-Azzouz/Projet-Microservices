package com.example.msdepot.entities;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
@Document
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Depot implements Serializable {
    @Id
    @Setter(AccessLevel.NONE)
    String idDepot;
    String nomDepot;
    String emplacement;
}
