package com.status.enrollees.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.status.enrollees.entity.Enrollee;
import com.status.enrollees.entity.EnrolleeDependent;

/**
 * Interface for EnrollleeDependent Repository
 * 
 * @author Shailja Sharma
 */
public interface EnrollleeDependentRepository extends JpaRepository<EnrolleeDependent, Integer> {

	/**
	 * Retrieve all the dependents of the Enrollee
	 * 
	 * @return list of dependents.
	 */
	List<EnrolleeDependent> findByEnrollee(Enrollee enrollee);

	void save(Optional<EnrolleeDependent> enrolleeDependent);

}
