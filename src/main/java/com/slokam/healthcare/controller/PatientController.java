package com.slokam.healthcare.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.pojo.PatientSearchPojo;
import com.slokam.healthcare.service.IPatientService;
import com.slokam.healthcare.util.NullCheckForPatient;

@RestController
@RequestMapping("patient")
public class PatientController {

	private static Logger LOGGER = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private IPatientService patientService;
	
	@Value("${app.file.upload.location}")
	private String uploadLocation;
	
	@PostMapping("/register")
	public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient){
		LOGGER.trace("Entered in to registerPatient");
		LOGGER.debug("User registering Data:"+patient);
		patientService.patientRegistration(patient);
		LOGGER.debug("User registered Data:"+patient);
		LOGGER.trace("Exit from registerPatient");
		return new ResponseEntity<Patient>(patient,HttpStatus.CREATED);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<Patient>> patientFullSearch(@RequestBody PatientSearchPojo patientSearch){
		LOGGER.trace("Entered in to patientFullSearch");
		LOGGER.trace("User Search Data:"+patientSearch);
		List<Patient> patientList = patientService.patientFullSearch(patientSearch);
		LOGGER.trace("User Search Result:"+patientList);
		LOGGER.trace("Exit from patientFullSearch");
		return ResponseEntity.ok(patientList);
	}
	
	@GetMapping("/get/{name}/{email}")
	public ResponseEntity<List<Patient>> patientSearchByNameAndEmail(@PathVariable String name, @PathVariable String email){
		LOGGER.trace("Entered in to patientSearchByNameAndEmail");
		LOGGER.debug("User Search Data by Name & Email"+name+"===="+email);
		List<Patient> patientList = patientService.patientSearchByNameAndEmail(name, email);
		LOGGER.debug("User Search Data:"+patientList);
		patientList.forEach(e -> System.out.println(e.getName()));
		LOGGER.info("User Search Data:"+patientList);
		LOGGER.trace("Exit from patientSearchByNameAndEmail");
		return new ResponseEntity<>(patientList,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Patient>> getAllPatients(){
		LOGGER.trace("Entered in to getAllPatients");
		List<Patient> patientList = patientService.getAllPatients();
		LOGGER.debug("User Got All Data:"+patientList);
		LOGGER.trace("Exit from getAllPatients");
		return ResponseEntity.ok(patientList);
	}
	
	@GetMapping("byId/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Integer id) {
		LOGGER.trace("Entered in to getPatientById");
		LOGGER.debug("User Get Data by Id:"+id);
		Patient patient = patientService.getPatientById(id);
		LOGGER.debug("User Got Data"+patient);
		LOGGER.trace("Exit from getPatientById");
		return ResponseEntity.ok(patient);
	}
	
	@GetMapping("/getAllEvenPatients")
	public ResponseEntity<List<Patient>> getAllEvenPatients(){
		LOGGER.trace("Entered in to getAllEvenPatients");
		List<Patient> patientList = patientService.getAllPatients();
		LOGGER.debug("User Get Data:"+patientList);
		List<Patient> evenPatientList = patientList.stream().filter(patient -> patient.getId() % 2 == 0).collect(Collectors.toList());
		LOGGER.debug("User Get Data Based on Even Number Id:"+evenPatientList);
		LOGGER.trace("Exit from getAllEvenPatients");
		return ResponseEntity.ok(evenPatientList);
		
		// getAllEvenPatients by using stream() (Java 1.8)
		
		/*return ResponseEntity.ok(patientService.getAllPatients().stream().filter(patient -> NullCheckForPatient.nullCheckForPatient(patient))
				.collect(Collectors.toList()));*/
	}
	
	@GetMapping("/getPatientsByAge")
	public ResponseEntity<List<Patient>> getAllPatientsByAge(){
		LOGGER.trace("Entered in to getAllPatientsByAge");
		List<Patient> patientListByAge = patientService.getAllPatients().stream().filter(patient -> NullCheckForPatient.nullCheckForPatient(patient))
				.collect(Collectors.toList());
		LOGGER.debug("User Get Data by Age:"+patientListByAge);
		LOGGER.trace("Exit from getAllPatientsByAge");
		return ResponseEntity.ok(patientListByAge);
	}
	
	@GetMapping("/getPatientsByName")
	public ResponseEntity<List<String>> getPatientNames(){
		LOGGER.trace("Entered in to getPatientNames");
		List<String> patientNames = patientService.getAllPatients().stream().map(Patient :: getName).collect(Collectors.toList());
		LOGGER.debug("User Get Data by Names:"+patientNames);
		LOGGER.trace("Exit from getPatientNames");
		return ResponseEntity.ok(patientNames);
	};
	
	@PostMapping("/saveImage")
	public ResponseEntity<String> savePatientImage(MultipartFile patientImage){
		LOGGER.trace("Entered in to savePatientImage");
		LOGGER.debug("User Saving Image:"+patientImage);
		String name = System.currentTimeMillis()+"-"+patientImage.getOriginalFilename();
		LOGGER.debug("User Get CurrentTime & Original FileName:"+name);
		try {
			patientImage.transferTo(new File(uploadLocation+name));
			LOGGER.trace("User transfer File in Location along with Name");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		LOGGER.debug("User saved Image");
		LOGGER.trace("Exit from savePatientImage");
		return new ResponseEntity<String>(name,HttpStatus.OK);
	}
	
}
