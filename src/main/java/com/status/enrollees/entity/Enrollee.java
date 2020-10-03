package com.status.enrollees.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity class for Enrollee
 * 
 * @author Shailja Sharma
 */
@Entity
@Table(name = "enrollee")
public class Enrollee {

	@Id
	@Column(name = "enrollee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrolleeId;

	@Column(name = "name_en", nullable = false)
	private String name;

	@Column(name = "activation_status", nullable = false)
	private Boolean activationStatus;

	@Column(name = "phone_number", nullable = true)
	private long phoneNumber;

	@Column(name = "birth_date", nullable = true)
	private Date birthDate;

	@OneToMany(mappedBy = "enrollee", cascade = CascadeType.ALL)
	private List<EnrolleeDependent> enrolleeDependents;

	public List<EnrolleeDependent> getEnrolleeDependents() {
		return enrolleeDependents;
	}

	public void setEnrolleeDependents(List<EnrolleeDependent> enrolleeDependents) {
		this.enrolleeDependents = enrolleeDependents;
	}

	public int getEnrolleeId() {
		return enrolleeId;
	}

	public void setEnrolleeId(int enrolleeId) {
		this.enrolleeId = enrolleeId;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(Boolean activationStatus) {
		this.activationStatus = activationStatus;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
