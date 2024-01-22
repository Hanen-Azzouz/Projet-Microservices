package esprit.tn.mshonorairequery.events;

import esprit.tn.dto.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {
    private final HonoraireEventHandler honoraireEventHandler;
    private final String topic="honoraire-event-topic";
    @KafkaListener(topics = topic,groupId = "my-group")
    public void consume(ConsumerRecord<String, Event> consumerRecord){
        Event event=consumerRecord.value();
        log.info(" \n Consumed Event of type : {} \n published on topic at : {} \n Data value is : {}", event.type(), event.eventCreatedAt(), event.honoraireDto());
        switch(consumerRecord.key()){
            case "CREATED_HONORAIRE_EVENT":
                honoraireEventHandler.handleHonoraireCreatedEvent(event.honoraireDto());
                break;
            case "UPDATED_HONORAIRE_EVENT":
                honoraireEventHandler.handleHonoraireUpdatedEvent(event.honoraireDto());
                break;
            case "DELETED_HONORAIRE_EVENT":
                honoraireEventHandler.handleHonoraireDeletedEvent(event.honoraireDto().idHonoraire());
                break;
            default:
                log.info("Event ignored");
                break;

        }



    }



}
