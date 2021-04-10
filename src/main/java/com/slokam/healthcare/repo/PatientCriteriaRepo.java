package com.slokam.healthcare.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.pojo.PatientSearchPojo;
import com.slokam.healthcare.util.StringUtils;

@Repository
public class PatientCriteriaRepo {

	private static Logger LOGGER = LoggerFactory.getLogger(PatientCriteriaRepo.class);
	
	@Autowired
	private EntityManager em;
	
	public List<Patient> patientFullSearch(PatientSearchPojo patientSearch){
		LOGGER.trace("Entered in to patientFullSearch");
		LOGGER.debug("Search Data:"+patientSearch);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Patient> cq = cb.createQuery(Patient.class);
		Root<Patient> root = cq.from(Patient.class);
		List<Predicate> predicateList = new ArrayList<Predicate>();
		if (patientSearch != null) {
			LOGGER.trace("Entered in to Criteria Predicate");
			if (StringUtils.blankCheck(patientSearch.getName())) {
				LOGGER.trace("Entered in to get Name Predicate");
				predicateList.add(cb.like(root.get("name"), patientSearch.getName()));
				LOGGER.trace("Exit from get Name Predicate");
			}
			if (patientSearch.getPhone() != null) {
				LOGGER.trace("Entered in to get Phone Predicate");
				predicateList.add(cb.equal(root.get("phone"), patientSearch.getPhone()));
				LOGGER.trace("Exit from get Phone Predicate");
			}
			if (patientSearch.getFromDate() != null) {
				LOGGER.trace("Entered in to get from Date Predicate");
				predicateList.add(cb.greaterThan(root.get("registeredDate"), patientSearch.getFromDate()));
				LOGGER.trace("Exit from get from Date Predicate");
			}
			if (patientSearch.getToDate() != null) {
				LOGGER.trace("Entered in to get to Date Predicate");
				predicateList.add(cb.lessThan(root.get("registeredDate"), patientSearch.getToDate()));
				LOGGER.trace("Exit from get to Date Predicate");
			}
			if (patientSearch.getStartingAge() != null) {
				LOGGER.trace("Entered in to get Starting Age Predicate");
				predicateList.add(cb.ge(root.get("age"), patientSearch.getStartingAge()));
				LOGGER.trace("Exit from get Starting Age Predicate");
			}
			if (patientSearch.getEndingAge() != null) {
				LOGGER.trace("Entered in to get Ending Age Predicate");
				predicateList.add(cb.le(root.get("age"), patientSearch.getEndingAge()));
				LOGGER.trace("Exit from get Ending Age Predicate");
			}
			LOGGER.trace("Exit from Criteria Predicate");
		}
		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));
		TypedQuery<Patient> patientQuery = em.createQuery(cq);
		
		List<Patient> patientList = patientQuery.getResultList();
		LOGGER.debug("Search Result:"+patientSearch);
		LOGGER.trace("Exit from patientFullSearch");
		return patientList;
	}
	
	//===============================================================================================================================
	
	public List<Patient> patientSearchByNameAndEmail(String name, String email){
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		System.out.println(cb);
		CriteriaQuery<Patient> cq = cb.createQuery(Patient.class);
		System.out.println(cq);
		Root<Patient> root = cq.from(Patient.class);
		System.out.println(root);
		List<Predicate> predicateList = new ArrayList<Predicate>();
		if (name != null && name.trim().length() > 0 ) {
			predicateList.add(cb.equal(root.get("name"), name));
		}
		if (email != null && email.trim().length() > 0) {
			predicateList.add(cb.like(root.get("email"), "%" + email + "%"));
		}
		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));
		TypedQuery<Patient> patientQuery = em.createQuery(cq);
		
		System.out.println(patientQuery);
		return patientQuery.getResultList();
	}
}
