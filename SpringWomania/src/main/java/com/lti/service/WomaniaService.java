package com.lti.service;

import java.util.List;

import com.lti.model.City;
import com.lti.model.Hostel;
import com.lti.model.Occupation;
import com.lti.model.State;
import com.lti.model.StepFamilyDetails;
import com.lti.model.StepPersonalDetails;
import com.lti.model.StepRegister;
import com.lti.model.Training;


public interface WomaniaService {
	//login services
	public List<StepRegister> loginDetail(String userName, String password);
	
	//select statements
	public  List<StepRegister> findAllStepDetails();
	public List<StepPersonalDetails> findAllPersonalDetails();
	public List<Occupation> findAllStepOccupationDetails();
	public List<StepPersonalDetails> findStepPersonalWithOccupation();
	public List<StepFamilyDetails> findStepFamilyDetails();
	public List<City> findCityDetails();
	public List<State> findStateDetails();
	public List<Hostel> findHostelDetails();
	public List<Training> findTrainingDetails();
	
	
	
	//insert statements
	public boolean addStep(StepRegister step);
	public boolean addpersonal(StepPersonalDetails person);
	public boolean addFamily(StepFamilyDetails family);
	
 }
