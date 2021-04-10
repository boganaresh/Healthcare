package com.slokam.healthcare.util;

import java.util.Objects;

import com.slokam.healthcare.entity.Patient;

public class NullCheckForPatient {
	
	public static boolean nullCheckForPatient(Patient patient) {
		boolean result = false;
		if (Objects.nonNull(patient) && patient.getId() != null && patient.getId() % 2 == 0 && patient.getAge() != null && patient.getAge() > 60) {
			result = true;
		}
		return result;
	}
}
