package esprit.tn.mshonorairequery.events;

import esprit.tn.dto.HonoraireDto;
import esprit.tn.mshonorairequery.services.IHonoraireQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HonoraireEventHandler {

    private final IHonoraireQueryService honoraireRest;

    public void handleHonoraireCreatedEvent(HonoraireDto honoraireDto){
        honoraireRest.add(HonoraireDto.mapToEntity(honoraireDto));
    }
    public void handleHonoraireUpdatedEvent(HonoraireDto honoraireDto){
        honoraireRest.update(HonoraireDto.mapToEntity(honoraireDto));
    }
    public void handleHonoraireDeletedEvent(long idHonoraire){
        honoraireRest.delete(idHonoraire);
    }



}
