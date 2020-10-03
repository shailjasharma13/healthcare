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
import com.status.enrollees.repository.EnrolleeDependentService;
import com.status.enrollees.repository.EnrolleeService;

/**
 * RestContoller for CRUD operations on Enrollee
 * 
 * @author Shailja Sharma
 */
@RestController
public class EnrolleesController {

	@Autowired
	EnrolleeService enrolleesService;

	@Autowired
	EnrolleeDependentService enrolleeDependentService;

	@GetMapping("/enrollees")
	public List<Enrollee> list() {
		return enrolleesService.listAll();
	}

	@PostMapping("/enrollees")
	public Enrollee addEnrollee(@RequestBody Enrollee enrollees) {
		Enrollee newEnrollee = enrolleesService.save(enrollees);
		return newEnrollee;
	}

	@PutMapping("/enrollees/{id}")
	public Enrollee upDateEnrollee(@PathVariable(value = "id") int enrolleeId, @RequestBody Enrollee enrollee)
			throws ResourceNotFoundException {
		Enrollee enrollee1 = enrolleesService.get(enrolleeId);
		if (enrollee1 != null) {
			enrollee1.setName(enrollee.getName());
			enrollee1.setBirthDate(enrollee.getBirthDate());
			enrollee1.setActivationStatus(enrollee.getActivationStatus());
			enrollee1.setPhoneNumber(enrollee.getPhoneNumber());
			Enrollee updatedEnrolle = enrolleesService.save(enrollee1);
			return updatedEnrolle;
		} else {
			throw new ResourceNotFoundException(" Enrollee not found :: " + enrolleeId);

		}

	}

	@DeleteMapping("/enrollees/{id}")
	public void deleteEnrollee(@PathVariable(value = "id") int enrolleeId) {
		enrolleesService.delete(enrolleeId);

	}

}
