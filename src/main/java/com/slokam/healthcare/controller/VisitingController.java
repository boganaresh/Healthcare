package com.slokam.healthcare.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.healthcare.service.IVisitingService;

@RestController
@RequestMapping("visiting")
public class VisitingController {

	private static Logger LOGGER = LoggerFactory.getLogger(VisitingController.class);
	
	@Autowired
	private IVisitingService visitingService;
	
	@GetMapping("/getPatientById/{id}")
	public ResponseEntity<List<Object[]>> getVisitingByPatientId(@PathVariable Integer id){
		LOGGER.trace("Entered in to getVisitingByPatientId");
		LOGGER.debug("User Get Data by Id:"+id);
		List<Object[]> visitingList = visitingService.getVisitingByPatientId(id);
		LOGGER.debug("User Got Data Result by Id:"+visitingList);
		LOGGER.trace("Exit from getVisitingByPatientId");
		return ResponseEntity.ok(visitingList);
	}
}
