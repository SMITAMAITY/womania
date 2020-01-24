package com.lti.model;

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

@Component("hostel")
@Entity
@Table(name = "Hostel")
@SequenceGenerator(name="seq_hostel",sequenceName="seq_hostel",allocationSize=1,initialValue=1)
public class Hostel {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_hostel")
	@Column(name="hostel_Id")
	private int hostelId;
	@Column(name="hostel_name")
	private String hostelName;
	@Column(name="bed_availability")
	private int bedAvailability;

	@ManyToOne
	@Autowired
	@JsonBackReference
	@JoinColumn(name="city_id")
	private City city;

	/*@OneToMany(mappedBy="hostel",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Trainee> trainee;
	
	@OneToMany(mappedBy="hostel",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<SelfEmployeeDetails> selfEmployeeDetails;*/
	
	public Hostel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hostel(int hostelId, String hostelName, int bedAvailability, City city) {
		super();
		this.hostelId = hostelId;
		this.hostelName = hostelName;
		this.bedAvailability = bedAvailability;
		this.city = city;
	}

	public int getHostelId() {
		return hostelId;
	}

	public void setHostelId(int hostelId) {
		this.hostelId = hostelId;
	}

	public String getHostelName() {
		return hostelName;
	}

	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}

	public int getBedAvailability() {
		return bedAvailability;
	}

	public void setBedAvailability(int bedAvailability) {
		this.bedAvailability = bedAvailability;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Hostel [hostelId=" + hostelId + ", hostelName=" + hostelName + ", bedAvailability=" + bedAvailability
				+ ", city=" + city + "]";
	}

}
