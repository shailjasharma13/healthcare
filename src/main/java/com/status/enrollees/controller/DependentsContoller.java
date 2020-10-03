package com.status.enrollees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.status.enrollee.exception.ResourceNotFoundException;
import com.status.enrollees.entity.Enrollee;
import com.status.enrollees.entity.EnrolleeDependent;
import com.status.enrollees.repository.EnrolleeDependentService;
import com.status.enrollees.repository.EnrolleeService;

/**
 * RestContoller for CRUD operations on Dependents
 * 
 * @author Shailja Sharma
 */
@RestController
public class DependentsContoller {

	@Autowired
	EnrolleeService enrolleesService;

	@Autowired
	EnrolleeDependentService enrolleeDependentService;

	@GetMapping("/enrollees/{id}/dependents")
	public List<EnrolleeDependent> addEnrollee(@PathVariable(value = "id") int enrolleeId) {
		return enrolleeDependentService.getAllDependents(enrolleeId);

	}

	@PostMapping("/enrollees/{id}/dependents")
	public EnrolleeDependent addDependents(@PathVariable(value = "id") int enrolleeId,
			@RequestBody EnrolleeDependent enrolleeDependent) throws ResourceNotFoundException {
		Enrollee enrollee = enrolleesService.get(enrolleeId);
		if (enrollee != null) {
			enrolleeDependent.setEnrollee(enrollee);
			EnrolleeDependent updatedEnrolleeDependent = enrolleeDependentService.save(enrolleeDependent);
			return updatedEnrolleeDependent;
		} else {
			throw new ResourceNotFoundException(" Dependent not found :: " + enrolleeId);
		}

	}

	@DeleteMapping("/enrollees/{id}/dependents")
	public void deleteDependents(@PathVariable(value = "id") int enrolleeId) {
		List<EnrolleeDependent> dependents = enrolleeDependentService.getAllDependents(enrolleeId);
		for (EnrolleeDependent dependent : dependents) {
			enrolleeDependentService.delete(dependent.getDependentId());
		}

	}

	@PutMapping("/enrollees/{id}/dependents/{dependentId}")
	public EnrolleeDependent updateDependents(@PathVariable(value = "id") int enrolleeId,
			@PathVariable(value = "dependentId") int dependentId, @RequestBody EnrolleeDependent enrolleeDependent)
			throws ResourceNotFoundException {
		Enrollee enrollee = enrolleesService.get(enrolleeId);
		if (enrollee != null) {
			EnrolleeDependent dependent = enrolleeDependentService.get(dependentId);
			if (dependent != null) {
				dependent.setEnrollee(enrollee);
				dependent.setdependentName(enrolleeDependent.getdependentName());
				dependent.setBirthDate(enrolleeDependent.getBirthDate());
				return enrolleeDependentService.save(dependent);
			} else {
				throw new ResourceNotFoundException(" Dependent not found :: " + dependentId);
			}
		} else {
			throw new ResourceNotFoundException(" Enrollee not found :: " + enrolleeId);
		}

	}

}
