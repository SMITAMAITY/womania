package com.lti.dao;

import java.util.List;

import com.lti.model.City;
import com.lti.model.Hostel;
import com.lti.model.Occupation;
import com.lti.model.State;
import com.lti.model.StepFamilyDetails;
import com.lti.model.StepPersonalDetails;
import com.lti.model.StepRegister;
import com.lti.model.Training;


public interface WomaniaDao {
	//login details
	public List<StepRegister> loginDetails(String userName ,String password);
	
	
	//select data from table
	public List<StepRegister> readAllStepDetails();
	public List<StepPersonalDetails> readStepPersonalDetails();
	public List<Occupation> readStepOccupationDetails();
	public List<StepPersonalDetails> readStepPersonalWithOccupation();
	public List<StepFamilyDetails> readStepFamilyDetails();
	public List<City> readCity();
	public List<State> readState();
	public List<Hostel> readHostel();
	public List<Training> readTrainingDetails();
	
	
	//insert data to table
	public int createStep(StepRegister step);
	public int createStepPersonalDetails(StepPersonalDetails person);
	public int createStepFamilyDetails(StepFamilyDetails family);
	
}
