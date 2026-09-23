package com.klu.bin.controller;

import com.klu.bin.entity.Bin;
import com.klu.bin.repository.BinRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bins")
public class BinController {

    private final BinRepository binRepository;

    public BinController(BinRepository binRepository) {
        this.binRepository = binRepository;
    }

    // Add a new bin
    @PostMapping
    public Bin addBin(@RequestBody Bin bin) {
        return binRepository.save(bin);
    }

    // Get all bins
    @GetMapping
    public List<Bin> getAllBins() {
        return binRepository.findAll();
    }

    // Get bin by ID
    @GetMapping("/{id}")
    public Bin getBinById(@PathVariable Long id) {
        return binRepository.findById(id).orElse(null);
    }

    // Delete bin
    @DeleteMapping("/{id}")
    public String deleteBin(@PathVariable Long id) {
        binRepository.deleteById(id);
        return "Bin deleted successfully";
    }
}