package esprit.tn.dto;

import java.time.LocalDateTime;

public record Event(EventType type, HonoraireDto honoraireDto, LocalDateTime eventCreatedAt) {
}
