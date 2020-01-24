package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.City;
import com.lti.model.Hostel;
import com.lti.model.Occupation;
import com.lti.model.State;
import com.lti.model.StepFamilyDetails;
import com.lti.model.StepPersonalDetails;
import com.lti.model.StepRegister;
import com.lti.model.Training;

@Repository
public class WomaniaDaoImpl implements WomaniaDao {
	@PersistenceContext
	@Autowired
	private EntityManager entityManager;

	public WomaniaDaoImpl() {

	}

	//LOGIN
	@Override
	public List<StepRegister> loginDetails(String userName,String password) 
			{
		String jpql = "Select userName, password From StepRegister  where userName=:userName and password=:password";
		TypedQuery<StepRegister> tquery=entityManager.createQuery(jpql,StepRegister.class);
		tquery.setParameter("userName", userName);
		tquery.setParameter("password", password);
		//return tquery.getSingleResult();
		return tquery.getResultList();
		 
	}
	// Select Queries
	@Override
	public List<StepRegister> readAllStepDetails() {
		String jpql = "From StepRegister";
		TypedQuery<StepRegister> tquery = entityManager.createQuery(jpql, StepRegister.class);
		return tquery.getResultList();

	}

	@Override
	public List<StepPersonalDetails> readStepPersonalDetails() {
		String jpql = "From StepPersonalDetails";
		TypedQuery<StepPersonalDetails> tquery = entityManager.createQuery(jpql, StepPersonalDetails.class);
		List<StepPersonalDetails> result = tquery.getResultList();
		System.out.println(result);
		return result;
	}

	@Override
	public List<Occupation> readStepOccupationDetails() {
		String jpql = "From Occupation";
		TypedQuery<Occupation> tquery = entityManager.createQuery(jpql, Occupation.class);
		return tquery.getResultList();
	}

	@Override
	public List<StepPersonalDetails> readStepPersonalWithOccupation() {
		String name = "Trainee";
		String jpql = "From StepPersonalDetails where occupation in(select occupationId from Occupation where occupationName='"
				+ name + "')";
		TypedQuery<StepPersonalDetails> tquery = entityManager.createQuery(jpql, StepPersonalDetails.class);
		System.out.println("123");
		return tquery.getResultList();
	}

	@Override
	public List<StepFamilyDetails> readStepFamilyDetails() {
		String jpql = "From StepFamilyDetails";
		TypedQuery<StepFamilyDetails> tquery = entityManager.createQuery(jpql, StepFamilyDetails.class);
		return tquery.getResultList();
	}

	@Override
	public List<City> readCity() {
		String jpql = "From City";
		TypedQuery<City> tquery = entityManager.createQuery(jpql, City.class);
		return tquery.getResultList();
	}

	@Override
	public List<State> readState() {
		String jpql = "From State";
		TypedQuery<State> tquery = entityManager.createQuery(jpql, State.class);
		return tquery.getResultList();
	}

	@Override
	public List<Hostel> readHostel() {
		String jpql = "From Hostel";
		TypedQuery<Hostel> tquery = entityManager.createQuery(jpql, Hostel.class);
		return tquery.getResultList();
	}

	@Override
	public List<Training> readTrainingDetails() {
		String jpql = "From Training";
		TypedQuery<Training> tquery = entityManager.createQuery(jpql, Training.class);
		return tquery.getResultList();
	}

	

	// Insert Queries
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int createStep(StepRegister step) {
		entityManager.persist(step);
		return 1;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int createStepPersonalDetails(StepPersonalDetails person) {
		entityManager.persist(person);
		return 1;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int createStepFamilyDetails(StepFamilyDetails family) {
		entityManager.persist(family);
		return 1;
	}

	
}
