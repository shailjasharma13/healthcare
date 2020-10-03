package com.status.enrollees.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity class for Enrollee Dependent
 * 
 * @author Shailja Sharma
 */
@Entity
@Table(name = "dependents")
public class EnrolleeDependent {

	@Id
	@Column(name = "dependent_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dependentId;

	@Column(name = "dependent_name", nullable = false)
	private String dependentName;

	@Column(name = "birth_date", nullable = false)
	private Date birthDate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.ALL)
	@JoinColumn(name = "enrollee_id", nullable = false)
	@JsonIgnore
	private Enrollee enrollee;

	public int getDependentId() {
		return dependentId;
	}

	public void setDependentId(int dependentId) {
		this.dependentId = dependentId;
	}

	public Enrollee getEnrollee() {
		return enrollee;
	}

	public void setEnrollee(Enrollee enrollee) {
		this.enrollee = enrollee;
	}

	public String getdependentName() {
		return dependentName;
	}

	public void setdependentName(String dependentName) {
		this.dependentName = dependentName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
