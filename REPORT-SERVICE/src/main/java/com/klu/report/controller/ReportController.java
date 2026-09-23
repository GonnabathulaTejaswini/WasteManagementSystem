package com.klu.report.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klu.report.entity.Report;
import com.klu.report.repository.ReportRepository;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportRepository repository;

    public ReportController(ReportRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Report createReport(@RequestBody Report report) {
        if (report.getStatus() == null) {
            report.setStatus("PENDING");
        }
        if (report.getPriority() == 0) {
            report.setPriority(1);
        }
        return repository.save(report);
    }

    @GetMapping
    public List<Report> getAllReports() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Report getReport(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteReport(@PathVariable Long id) {
        repository.deleteById(id);
        return "Report deleted successfully";
    }
}