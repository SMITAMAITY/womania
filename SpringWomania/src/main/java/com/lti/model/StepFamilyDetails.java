package com.lti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("stepFamilyDetails")
@Entity
@Table(name = "Step_Family_Details")
@SequenceGenerator(name = "seq_family", sequenceName = "seq_family", allocationSize = 1, initialValue = 1)
public class StepFamilyDetails implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_family")
	@Column(name = "FId")
	private int familyId;
	@Column(name = "Relation")
	private String relation;
	@Column(name = "Full_Name")
	private String fullName;
	@Column(name = "Age")
	private int age;
	@Column(name = "Occupation")
	private String occupation;

	@ManyToOne
	@JoinColumn(name = "pid")
	@Autowired
	private StepPersonalDetails stepPersonalDetails;

	public StepFamilyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StepFamilyDetails(int familyId, String relation, String fullName, int age, String occupation,
			StepPersonalDetails stepPersonalDetails) {
		super();
		this.familyId = familyId;
		this.relation = relation;
		this.fullName = fullName;
		this.age = age;
		this.occupation = occupation;
		this.stepPersonalDetails = stepPersonalDetails;
	}

	public int getFamilyId() {
		return familyId;
	}

	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public StepPersonalDetails getStepPersonalDetails() {
		return stepPersonalDetails;
	}

	public void setStepPersonalDetails(StepPersonalDetails stepPersonalDetails) {
		this.stepPersonalDetails = stepPersonalDetails;
	}

	@Override
	public String toString() {
		return "StepFamilyDetails [familyId=" + familyId + ", relation=" + relation + ", fullName=" + fullName
				+ ", age=" + age + ", occupation=" + occupation + ", stepPersonalDetails=" + stepPersonalDetails + "]";
	}

}
