package com.slokam.healthcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.healthcare.entity.Patient;

@Repository
public interface IPatientRepo extends JpaRepository<Patient, Integer> {

}
