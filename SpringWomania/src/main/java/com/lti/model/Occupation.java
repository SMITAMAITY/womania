package com.lti.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component("occupation")
@Entity
@Table(name = "Occupation")
@SequenceGenerator(name = "seq_occupation", sequenceName = "seq_occupation", allocationSize = 1, initialValue = 1)
public class Occupation implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_occupation")
	@Column(name = "occupation_id")
	private int occupationId;
	@Column(name = "occupation_name")
	private String occupationName;

	@JsonManagedReference
	@OneToMany(mappedBy = "occupation",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<StepPersonalDetails> stepPersonalDetails;

	public Occupation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Occupation(int occupationId, String occupationName) {
		super();
		this.occupationId = occupationId;
		this.occupationName = occupationName;
	}

	public int getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(int occupationId) {
		this.occupationId = occupationId;
	}

	public String getOccupationName() {
		return occupationName;
	}

	public void setOccupationName(String occupationName) {
		this.occupationName = occupationName;
	}

	@Override
	public String toString() {
		return "Occupation [occupationId=" + occupationId + ", occupationName=" + occupationName + "]";
	}

	public Set<StepPersonalDetails> getStepPersonalDetails() {
		return stepPersonalDetails;
	}

	public void setStepPersonalDetails(Set<StepPersonalDetails> stepPersonalDetails) {
		this.stepPersonalDetails = stepPersonalDetails;
	}

}
