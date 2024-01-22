package esprit.tn.mshonorairecommand.services;

import esprit.tn.dto.Event;
import esprit.tn.dto.EventType;
import esprit.tn.dto.HonoraireDto;
import esprit.tn.mshonorairecommand.entities.Honoraire;
import esprit.tn.mshonorairecommand.events.KafkaProducer;
import esprit.tn.mshonorairecommand.repositories.HonoraireRepository;
import lombok.RequiredArgsConstructor;
import org.apache.el.util.ReflectionUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HonoraireService implements IHonoraireService{
    private  final HonoraireRepository honoraireRepos;

    private final KafkaProducer kafkaProducer;


    @Override
    public HonoraireDto add(HonoraireDto honoraireDto) {
        Honoraire honoraire=HonoraireDto.mapToEntity(honoraireDto);
        honoraire.setDateHonoraire(LocalDateTime.now());
        honoraireDto=HonoraireDto.mapToDTO(honoraireRepos.save(honoraire));
        kafkaProducer.produceEvent(new Event(EventType.CREATED_HONORAIRE_EVENT,honoraireDto,LocalDateTime.now()));
        return honoraireDto;
    }

    @Override
    public HonoraireDto update(long idHonoraire, Map<Object, Object> fields) {
        Honoraire honoraire=honoraireRepos.findById(idHonoraire)
                .orElseThrow(()-> new IllegalArgumentException("Honoraire not Found"+idHonoraire));
        fields.forEach((key,value)->{
            Field field= ReflectionUtils.findField(Honoraire.class,(String) key);
            field.setAccessible(true);

            if(field.getType().equals(LocalDate.class)){
                DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
                LocalDate localDate=LocalDate.parse((String) value,formatter);
                ReflectionUtils.setField(field,honoraire,localDate);
            }else{
                ReflectionUtils.setField(field,honoraire,value);
            }
    });
        HonoraireDto honoraireDto=HonoraireDto.mapToDTO(honoraireRepos.save(honoraire));
        kafkaProducer.produceEvent(new Event(EventType.UPDATED_HONORAIRE_EVENT,honoraireDto,LocalDateTime.now()));

        return honoraireDto;
    }

    @Override
    public boolean delete(long idHonoraire) {
        HonoraireDto honoraireDto=HonoraireDto.mapToDTO(honoraireRepos.findById(idHonoraire)
                .orElseThrow(()->new IllegalArgumentException("Honoraire not Found"+idHonoraire)));
        honoraireRepos.deleteById(idHonoraire);
        kafkaProducer.produceEvent(new Event(EventType.DELETED_HONORAIRE_EVENT,honoraireDto,LocalDateTime.now()));

        return honoraireRepos.existsById(idHonoraire);
    }
}
