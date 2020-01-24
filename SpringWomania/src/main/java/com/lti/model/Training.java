package com.lti.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Component("training")
@Entity
@Table(name = "Training")
@SequenceGenerator(name = "seq_training", sequenceName = "seq_training", allocationSize = 1, initialValue = 1)
public class Training {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_training")
	@Column(name = "training_id")
	private int trainingId;
	@Column(name = "course_name")
	private String courseName;
	@Column(name = "duration")
	private int duration;
	@Column(name = "start_date")
	private Date startDate;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	/*
	 * @OneToOne(mappedBy="training") private Trainee trainee;
	 */

	public Training() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Training(int trainId, String courseName, int duration, Date startDate, City city) {
		super();
		this.trainingId = trainId;
		this.courseName = courseName;
		this.duration = duration;
		this.startDate = startDate;
		this.city = city;
	}

	public int getTrainId() {
		return trainingId;
	}

	public void setTrainId(int trainId) {
		this.trainingId = trainId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Training [trainId=" + trainingId + ", courseName=" + courseName + ", duration=" + duration
				+ ", startDate=" + startDate + ", city=" + city + "]";
	}

}
