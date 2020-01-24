package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.WomaniaDao;
import com.lti.model.City;
import com.lti.model.Hostel;
import com.lti.model.Occupation;
import com.lti.model.State;
import com.lti.model.StepFamilyDetails;
import com.lti.model.StepPersonalDetails;
import com.lti.model.StepRegister;
import com.lti.model.Training;

@Service("service")
public class WomaniaServiceImpl implements WomaniaService {
	@Autowired
	private WomaniaDao dao;
	
	//login
	@Override
	public List<StepRegister> loginDetail(String userName, String password) {
		return dao.loginDetails(userName, password);
	}


	// select
	@Override
	public List<StepRegister> findAllStepDetails() {
		return dao.readAllStepDetails();

	}

	@Override
	public List<StepPersonalDetails> findAllPersonalDetails() {
		return dao.readStepPersonalDetails();
	}

	@Override
	public List<Occupation> findAllStepOccupationDetails() {
		return dao.readStepOccupationDetails();
	}

	@Override
	public List<StepPersonalDetails> findStepPersonalWithOccupation() {
		return dao.readStepPersonalWithOccupation();
	}

	@Override
	public List<StepFamilyDetails> findStepFamilyDetails() {

		return dao.readStepFamilyDetails();
	}

	@Override
	public List<City> findCityDetails() {
		return dao.readCity();
	}

	@Override
	public List<State> findStateDetails() {
		return dao.readState();
	}

	@Override
	public List<Hostel> findHostelDetails() {
		return dao.readHostel();
	}

	@Override
	public List<Training> findTrainingDetails() {
		return dao.readTrainingDetails();
	}

	// insert
	@Override
	public boolean addStep(StepRegister step) {
		int result = dao.createStep(step);
		if (result == 1)
			return true;
		else
			return false;

	}

	@Override
	public boolean addpersonal(StepPersonalDetails person) {
		int result = dao.createStepPersonalDetails(person);
		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean addFamily(StepFamilyDetails family) {
		int result = dao.createStepFamilyDetails(family);
		if (result == 1)
			return true;
		else
			return false;
	}



	
}
