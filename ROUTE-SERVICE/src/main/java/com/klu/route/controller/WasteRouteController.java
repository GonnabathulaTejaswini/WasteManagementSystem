package com.klu.route.controller;

import com.klu.route.entity.WasteRoute;
import com.klu.route.repository.WasteRouteRepository;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class WasteRouteController {

    private final WasteRouteRepository repository;

    public WasteRouteController(WasteRouteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public WasteRoute addRoute(@RequestBody WasteRoute route) {
        return repository.save(route);
    }

    @GetMapping
    public List<WasteRoute> getAllRoutes() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public WasteRoute getRouteById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteRoute(@PathVariable Long id) {
        repository.deleteById(id);
        return "Route deleted successfully";
    }
}