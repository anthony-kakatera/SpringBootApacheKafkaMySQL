package com.kafka.consumer.service;

import com.kafka.consumer.entity.WikimediaChanges;

public interface IWikimediaChangesService {
    public void save(WikimediaChanges wikimediaChanges);

    public void delete(WikimediaChanges wikimediaChanges);
}
