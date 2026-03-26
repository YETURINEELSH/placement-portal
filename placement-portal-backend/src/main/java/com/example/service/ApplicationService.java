package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Application;
import com.example.repository.ApplicationRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public Application applyJob(Application app) {

        boolean alreadyApplied = applicationRepository
                .existsByStudentIdAndJobId(app.getStudentId(), app.getJobId());

        if (alreadyApplied) {
            throw new RuntimeException("Already applied for this job!");
        }

        app.setStatus("APPLIED");
        return applicationRepository.save(app);
    }

    // ✅ ADD THIS METHOD (MISSING BEFORE)
    public List<Application> getApplicationsByStudent(Long studentId) {
        return applicationRepository.findByStudentId(studentId);
    }

    public Application updateStatus(Long id, String status) {
        Application app = applicationRepository.findById(id).orElse(null);

        if (app != null) {
            app.setStatus(status);
            return applicationRepository.save(app);
        }

        return null;
    }
}