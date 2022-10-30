package com.kafka.consumer.service;

import com.kafka.consumer.entity.WikimediaChanges;
import com.kafka.consumer.repository.IWikimediaChangesRepository;
import org.springframework.stereotype.Service;

@Service
public class WikimediaChangesService implements IWikimediaChangesService{

    private IWikimediaChangesRepository wikimediaChangesRepository;

    public WikimediaChangesService(IWikimediaChangesRepository wikimediaChangesRepository) {
        this.wikimediaChangesRepository = wikimediaChangesRepository;
    }

    @Override
    public void save(WikimediaChanges wikimediaChanges) {
        wikimediaChangesRepository.save(wikimediaChanges);
    }

    @Override
    public void delete(WikimediaChanges wikimediaChanges) {
        wikimediaChangesRepository.delete(wikimediaChanges);
    }
}
