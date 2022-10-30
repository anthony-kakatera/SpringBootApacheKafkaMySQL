package com.kafka.consumer;

import com.kafka.consumer.entity.WikimediaChanges;
import com.kafka.consumer.repository.IWikimediaChangesRepository;
import com.kafka.consumer.service.IWikimediaChangesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    //private IWikimediaChangesRepository iWikimediaChangesRepository;

    private IWikimediaChangesService iWikimediaChangesService;

    public KafkaConsumer(IWikimediaChangesService iWikimediaChangesService) {
        this.iWikimediaChangesService = iWikimediaChangesService;
    }

    @KafkaListener(
            topics = "wikimedia_recentchanges",
            groupId = "localGroup"
    )
    public void consumeMessage(String message){
        LOGGER.info(String.format("Event Received: %s", message));

        WikimediaChanges wikimediaChanges = new WikimediaChanges();
        wikimediaChanges.setData(message);

        iWikimediaChangesService.save(wikimediaChanges);
    }
}
