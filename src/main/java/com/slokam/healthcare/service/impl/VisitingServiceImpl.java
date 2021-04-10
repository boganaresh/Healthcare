package com.slokam.healthcare.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.slokam.healthcare.repo.IVisitingRepo;
import com.slokam.healthcare.service.IVisitingService;

@Repository
public class VisitingServiceImpl implements IVisitingService{

	private static Logger LOGGER = LoggerFactory.getLogger(VisitingServiceImpl.class);
	
	@Autowired
	private IVisitingRepo visitingRepo;
	
	@Override
	public List<Object[]> getVisitingByPatientId(Integer id) {
		LOGGER.trace("Entered in to getVisitingByPatientId");
		LOGGER.debug("Get Visiting Data by Id:"+id);
		List<Object[]> visitingList = visitingRepo.getVisitingByPatientId(id);
		LOGGER.debug("Visiting Data Result by Id:"+visitingList);
		LOGGER.trace("Exit from getVisitingByPatientId");
		return visitingList;
	}

}
