package com.status.enrollees.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.status.enrollees.entity.Enrollee;
import com.status.enrollees.service.EnrolleeRepository;

/**
 * Implementation class for EnrolleeService
 * 
 * @author Shailja Sharma
 */
@Service
public class EnrolleeServiceImpl implements EnrolleeService {

	@Autowired
	private EnrolleeRepository repo;

	/** {@inheritDoc} */
	@Override
	public List<Enrollee> listAll() {
		return repo.findAll();
	}

	/** {@inheritDoc} */
	@Override
	public Enrollee save(Enrollee enrollee) {
		repo.save(enrollee);
		return enrollee;
	}

	/** {@inheritDoc} */
	@Override
	public Enrollee get(Integer id) {
		if (repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}

		return null;
	}

	/** {@inheritDoc} */
	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
	}

}
