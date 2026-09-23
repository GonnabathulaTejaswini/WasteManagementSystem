package com.klu.collection.repository;

import com.klu.collection.entity.CollectionRecord;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository
        extends JpaRepository<CollectionRecord, Long> {

}