package esprit.tn.mshonorairecommand.events;

import esprit.tn.dto.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {


    private final KafkaTemplate<String, Event> kafkaTemplate;
    private String topic="honoraire-event-topic";

    public void produceEvent(Event honoraireEvent){
        kafkaTemplate.send(this.topic,honoraireEvent.type().toString(),honoraireEvent);
    }



}
