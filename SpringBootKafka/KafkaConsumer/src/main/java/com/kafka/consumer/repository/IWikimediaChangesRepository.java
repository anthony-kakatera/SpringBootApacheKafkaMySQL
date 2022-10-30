package com.kafka.consumer.repository;

import com.kafka.consumer.entity.WikimediaChanges;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWikimediaChangesRepository extends JpaRepository<WikimediaChanges, Integer> {
}
