package com.slokam.healthcare.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

@Entity
public class PrecItem implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "fkid22")
	private Treatment treatment;
	@OneToOne
	@JoinColumn(name = "fkid23")
	private Disease disease;
	@OneToOne
	@JoinColumn(name = "fkid24")
	private Med med;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Treatment getTreatment() {
		return treatment;
	}

	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	public Med getMed() {
		return med;
	}

	public void setMed(Med med) {
		this.med = med;
	}
}