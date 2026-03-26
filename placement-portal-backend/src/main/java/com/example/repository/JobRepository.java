package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}