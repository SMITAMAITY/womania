package com.lti.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Component("stepPersonalDetails")
@Table(name = "Step_Personal_Details")
@SequenceGenerator(name = "seq_personal", sequenceName = "seq_personal", allocationSize = 1, initialValue = 1)
public class StepPersonalDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "PID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_personal")
	private int pId;
	@Column(name = "Full_name")
	private String fullName;
	@Column(name = "DOB")
	private Date DOB;
	@Column(name = "Blood_Group")
	private String bloodGroup;
	@Column(name = "Address")
	private String address;
	@Column(name = "Marital_status")
	private String maritalStatus;
	@Column(name = "Contact")
	private long contact;
	@Column(name = "Email")
	private String email;

	@JsonBackReference
	@ManyToOne
	@Autowired
	@JoinColumn(name = "occupation_id")
	private Occupation occupation;

	@OneToMany(mappedBy = "stepPersonalDetails", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<StepFamilyDetails> stepFamilyDetails;

	/*
	 * @OneToOne(mappedBy = "personalDetails") private SelfEmployeeDetails
	 * selfEmployeeDetails;
	 * 
	 * @OneToOne(mappedBy = "personalDetails") private Trainee trainee;
	 */

	public StepPersonalDetails() {
		super();
	}

	public StepPersonalDetails(int pId, String fullName, Date dOB, String bloodGroup, String address,
			String maritalStatus, long contact, String email, Occupation occupation) {
		super();
		this.pId = pId;
		this.fullName = fullName;
		DOB = dOB;
		this.bloodGroup = bloodGroup;
		this.address = address;
		this.maritalStatus = maritalStatus;
		this.contact = contact;
		this.email = email;
		this.occupation = occupation;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDOB() {

		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	@Override
	public String toString() {
		return "StepPersonalDetails [pId=" + pId + ", fullName=" + fullName + ", DOB=" + DOB + ", bloodGroup="
				+ bloodGroup + ", address=" + address + ", maritalStatus=" + maritalStatus + ", contact=" + contact
				+ ", email=" + email + ", occupation=" + occupation + "]";
	}

}
