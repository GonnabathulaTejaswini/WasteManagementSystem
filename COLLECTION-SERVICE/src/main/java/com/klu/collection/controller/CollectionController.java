package com.klu.collection.controller;

import com.klu.collection.entity.CollectionRecord;
import com.klu.collection.repository.CollectionRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collections")
public class CollectionController {

    private final CollectionRepository repository;

    public CollectionController(CollectionRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public CollectionRecord addCollection(
            @RequestBody CollectionRecord record) {

        return repository.save(record);
    }

    @GetMapping
    public List<CollectionRecord> getAllCollections() {

        return repository.findAll();
    }

    @GetMapping("/{id}")
    public CollectionRecord getById(
            @PathVariable Long id) {

        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteCollection(
            @PathVariable Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Collection deleted successfully";
        }

        return "Collection not found";
    }
}