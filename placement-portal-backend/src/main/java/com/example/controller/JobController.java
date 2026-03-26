package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.model.Job;
import com.example.service.JobService;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "http://localhost:3000") // allow React
public class JobController {

    @Autowired
    private JobService jobService;

    // Add job
    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobService.saveJob(job);
    }

    // Get all jobs
    @GetMapping
    public List<Job> getJobs() {
        return jobService.getAllJobs();
    }
}