package com.status.enrollees.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.status.enrollees.entity.Enrollee;
import com.status.enrollees.entity.EnrolleeDependent;
import com.status.enrollees.service.EnrollleeDependentRepository;

/**
 * Implementation/Service class for EnrolleeDependents
 * 
 * @author Shailja Sharma
 */

@Service
public class EnrolleeDependentServiceImpl implements EnrolleeDependentService {

	@Autowired
	private EnrollleeDependentRepository repo;

	@Autowired
	private EnrolleeService enrolleeService;

	/** {@inheritDoc} */
	@Override
	public List<EnrolleeDependent> getAllDependents(int enrolleeId) {
		Enrollee enrollee = enrolleeService.get(enrolleeId);
		return repo.findByEnrollee(enrollee);
	}

	/** {@inheritDoc} */
	@Override
	public EnrolleeDependent save(EnrolleeDependent enrolleeDependent) {
		repo.save(enrolleeDependent);
		return enrolleeDependent;
	}

	/** {@inheritDoc} */
	@Override
	public EnrolleeDependent get(int dependentId) {
		if (repo.findById(dependentId).isPresent()) {
			return repo.findById(dependentId).get();
		}
		return null;
	}

	/** {@inheritDoc} */
	@Override
	public void delete(Integer dependentId) {
		repo.deleteById(dependentId);
	}

}
