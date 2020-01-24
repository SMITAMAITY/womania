package com.lti.model;

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

@Component("state")
@Entity
@Table(name = "state")
@SequenceGenerator(name="seq_state",sequenceName="seq_state",allocationSize=1,initialValue=1)
public class State {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_state")
	@Column(name = "state_id")
	private int stateId;
	@Column(name = "state_name")
	private String stateName;

	@JsonManagedReference
	@OneToMany(mappedBy="state",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<City> city;
	
	public State() {
		super();
		
	}

	public State(int stateId, String stateName) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", stateName=" + stateName + "]";
	}

	public Set<City> getCity() {
		return city;
	}

	public void setCity(Set<City> city) {
		this.city = city;
	}

}
