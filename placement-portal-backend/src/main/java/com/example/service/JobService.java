package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Job;
import com.example.repository.JobRepository;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    // Save job
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    // Get all jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}