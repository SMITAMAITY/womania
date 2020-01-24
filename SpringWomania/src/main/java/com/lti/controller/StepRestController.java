package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.City;
import com.lti.model.Hostel;
import com.lti.model.Occupation;
import com.lti.model.State;
import com.lti.model.StepFamilyDetails;
import com.lti.model.StepPersonalDetails;
import com.lti.model.StepRegister;
import com.lti.model.Training;
import com.lti.service.WomaniaService;

@RestController
@RequestMapping(path = "step")
@CrossOrigin
public class StepRestController {
	@Autowired
	private WomaniaService service;

	// login Controller
	// http://localhost:9090/step/login/christa123/lobo
	@RequestMapping(path = "/login/{userName}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StepRegister> viewStepLogin(@PathVariable("userName") String userName,
			@PathVariable("password") String password) 
			{
		List<StepRegister> result = service.loginDetail(userName,password);
		return result;
	}

	// Select Controllers
	// http://localhost:9090/step
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StepRegister> viewAllSteps() {
		List<StepRegister> step = service.findAllStepDetails();
		return step;
	}

	// http://localhost:9090/step/stepPersonal
	@RequestMapping(path = "/stepPersonal", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StepPersonalDetails> viewAllStepPersonalDetails() {
		List<StepPersonalDetails> step = service.findAllPersonalDetails();
		return step;
	}

	// http://localhost:9090/step/stepOccupation
	@RequestMapping(path = "/stepOccupation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Occupation> viewAllStepOccupationDetails() {
		List<Occupation> step = service.findAllStepOccupationDetails();
		return step;
	}

	// http://localhost:9090/step/stepPersonalOccupation
	@RequestMapping(path = "/stepPersonalOccupation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StepPersonalDetails> viewAllStepPersonalOccupation() {
		List<StepPersonalDetails> step = service.findStepPersonalWithOccupation();
		return step;
	}

	// http://localhost:9090/step/stepFamily
	@RequestMapping(path = "/stepFamily", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StepFamilyDetails> viewAllStepFamily() {
		List<StepFamilyDetails> step = service.findStepFamilyDetails();
		return step;
	}

	// http://localhost:9090/step/city
	@RequestMapping(path = "/city", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<City> viewAllCity() {
		List<City> step = service.findCityDetails();
		return step;
	}

	// http://localhost:9090/step/state
	@RequestMapping(path = "/state", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<State> viewAllState() {
		List<State> step = service.findStateDetails();
		return step;
	}

	// http://localhost:9090/step/hostel
	@RequestMapping(path = "/hostel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hostel> viewAllHostel() {
		List<Hostel> step = service.findHostelDetails();
		return step;
	}

	// http://localhost:9090/step/training
	@RequestMapping(path = "/training", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Training> viewAllTrainingDetails() {
		List<Training> step = service.findTrainingDetails();
		return step;
	}

	// Insert Controllers
	// http://localhost:9090/step
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addStepDetails(@RequestBody StepRegister step) {
		ResponseEntity<String> response;

		boolean result = service.addStep(step);
		if (result) {
			response = new ResponseEntity<String>("New candidate for MWCD  is added", HttpStatus.CREATED);
		} else {
			response = new ResponseEntity<String>("No one is added", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	// http://localhost:9090/step/stepPersonal
	@RequestMapping(path = "/stepPersonal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addStepPersonal(@RequestBody StepPersonalDetails person) {
		ResponseEntity<String> response;

		boolean result = service.addpersonal(person);
		if (result) {
			response = new ResponseEntity<String>("Personal Details for MWCD  is added", HttpStatus.CREATED);
		} else {
			response = new ResponseEntity<String>("Nothing is added", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	// http://localhost:9090/step/stepFamily
	@RequestMapping(path = "/stepFamily", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addStepFamily(@RequestBody StepFamilyDetails family) {
		ResponseEntity<String> response;

		boolean result = service.addFamily(family);
		if (result) {
			response = new ResponseEntity<String>("Family Details of Step is added", HttpStatus.CREATED);
		} else {
			response = new ResponseEntity<String>("Nothing is added", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}
}
