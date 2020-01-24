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
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component("city")
@Entity
@Table(name = "City")
@SequenceGenerator(name="seq_city",sequenceName="seq_city",allocationSize=1,initialValue=1)
public class City {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_city")
	@Column(name = "city_id")
	private int city_id;
	@Column(name = "city_name")
	private String cityName;

	@ManyToOne
	@Autowired
	@JsonBackReference
	@JoinColumn(name = "sid")
	private State state;
	
	@JsonManagedReference
	@OneToMany(mappedBy="city",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Hostel> hostel;
	
	@JsonManagedReference
	@OneToMany(mappedBy="city",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Training> training;
	
	

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(int city_id, String cityName, State state) {
		super();
		this.city_id = city_id;
		this.cityName = cityName;
		this.state = state;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", cityName=" + cityName + ", state=" + state + "]";
	}

	public Set<Hostel> getHostel() {
		return hostel;
	}

	public void setHostel(Set<Hostel> hostel) {
		this.hostel = hostel;
	}

	public Set<Training> getTraining() {
		return training;
	}

	public void setTraining(Set<Training> training) {
		this.training = training;
	}

}
