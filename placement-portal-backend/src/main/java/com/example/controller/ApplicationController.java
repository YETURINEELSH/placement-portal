package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.model.Application;
import com.example.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // Apply for job
    @PostMapping
    public Application apply(@RequestBody Application app) {
        return applicationService.applyJob(app);
    }

    // Get student applications
    @GetMapping("/{studentId}")
    public List<Application> getApps(@PathVariable Long studentId) {
        return applicationService.getApplicationsByStudent(studentId);
    }

    // Update status
    @PutMapping("/{id}/status")
    public Application updateStatus(@PathVariable Long id,
                                   @RequestParam String status) {
        return applicationService.updateStatus(id, status);
    }
}