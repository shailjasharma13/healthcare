package com.status.enrollees.repository;

import java.util.List;

/**
 * Interface for Enrollee Service to perform database operation
 * 
 * @author Shailja Sharma
 */

import com.status.enrollees.entity.Enrollee;

public interface EnrolleeService {

	/**
	 * Get all the Enrollees
	 * 
	 * @return list of Enrollee.
	 */
	List<Enrollee> listAll();

	/**
	 * Save Enrolle
	 * 
	 * @param enrollee The enrollee to be saved
	 * @return Enrollee
	 */
	Enrollee save(Enrollee enrollee);

	/**
	 * Retrieve enrollee
	 * 
	 * @param enrolleeId The enrollee to be saved
	 * @return Enrollee
	 */
	Enrollee get(Integer enrolleeId);

	/**
	 * Delete enrollee
	 * 
	 * @param enrolleeId The enrollee to be delete
	 * @return Enrollee
	 */
	void delete(Integer enrolleeId);

}