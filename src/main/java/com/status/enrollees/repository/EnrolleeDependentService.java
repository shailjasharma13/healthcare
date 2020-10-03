package com.status.enrollees.repository;

import java.util.List;

/**
 * Interface for EnrolleeDependent Service
 * 
 * @author Shailja Sharma
 */
import com.status.enrollees.entity.EnrolleeDependent;

public interface EnrolleeDependentService {

	/**
	 * Get all dependents of the Enrollee
	 * 
	 * @param enrolleeId The enrollee id to retrieve dependents
	 * @return list of EnrolleDependent.
	 */

	List<EnrolleeDependent> getAllDependents(int enrolleeId);

	/**
	 * save dependent of the Enrollee
	 * 
	 * @param enrolleeDependent The dependent to be saved
	 * @return EnrolleeDependent Updated dependent
	 */

	EnrolleeDependent save(EnrolleeDependent enrolleeDependent);

	/**
	 * Retrieve the dependent information
	 * 
	 * @param dependentId The dependent id to be retrieved
	 * @return void
	 */
	EnrolleeDependent get(int dependentId);

	/**
	 * Delete the dependent information
	 * 
	 * @param dependentId The dependent id to be delete
	 * @return void
	 */
	void delete(Integer dependentId);

}