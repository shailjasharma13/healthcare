package com.status.enrollees.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.status.enrollees.entity.Enrollee;

/**
 * Interface for Enrollee Repository
 * 
 * @author Shailja Sharma
 */
public interface EnrolleeRepository extends JpaRepository<Enrollee, Integer> {

}
