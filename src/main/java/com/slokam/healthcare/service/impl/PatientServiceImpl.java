package com.slokam.healthcare.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.pojo.PatientSearchPojo;
import com.slokam.healthcare.repo.PatientCriteriaRepo;
import com.slokam.healthcare.repo.IPatientRepo;
import com.slokam.healthcare.service.IPatientService;

@Service
public class PatientServiceImpl implements IPatientService{

	private static Logger LOGGER = LoggerFactory.getLogger(PatientServiceImpl.class);
	
	@Autowired
	private IPatientRepo patientRepo;
	
	@Autowired
	private PatientCriteriaRepo patientCriteriaRepo;
	
	@Override
	public void patientRegistration(Patient patient) {
		LOGGER.trace("Entered in to patientRegistration");
		LOGGER.debug("Save Data:"+patient);
		patient.setRegisteredDate(new Date());
		patientRepo.save(patient);
		LOGGER.debug("Save Result:"+patient);
		LOGGER.trace("Exit from patientRegistration");
	}

	@Override
	public List<Patient> patientFullSearch(PatientSearchPojo patientSearch) {
		LOGGER.trace("Entered in to patientFullSearch");
		LOGGER.debug("Search Data:"+patientSearch);
		List<Patient> patientlist = patientCriteriaRepo.patientFullSearch(patientSearch);
		LOGGER.debug("Search Result:"+patientSearch);
		LOGGER.trace("Exit from patientFullSearch");
		return patientlist;
	}

	@Override
	public List<Patient> patientSearchByNameAndEmail(String name, String email) {
		LOGGER.trace("Entered in to patientSearchByNameAndEmail");
		LOGGER.debug("Search Data by Name & Email:"+name+"==="+email);
		List<Patient> patientList = patientCriteriaRepo.patientSearchByNameAndEmail(name, email);
		LOGGER.debug("Search Result by Name & Email:"+name+"==="+email);
		LOGGER.trace("Exit from patientSearchByNameAndEmail");
		return patientList;
	}

	@Override
	public List<Patient> getAllPatients() {
		LOGGER.trace("Entered in to getAllPatients");
		List<Patient> patientList =  patientRepo.findAll();
		LOGGER.debug("Get All Data:"+patientList);
		LOGGER.trace("Exit from getAllPatients");
		return patientList;
	}

	@Override
	public Patient getPatientById(Integer id) {
		LOGGER.trace("Entered in to getPatientById");
		LOGGER.debug("Get Data by Id:"+id);
		Optional<Patient> patientOpt = patientRepo.findById(id);
		LOGGER.debug("Optional Data through Find by Id:"+patientOpt);
		if (patientOpt.isPresent()) {
			LOGGER.debug("Optional Data is present");
			return patientOpt.get();
		}
		LOGGER.debug("Got Data by Id");
		LOGGER.trace("Exit from getPatientById");
		return null;
	}

}
