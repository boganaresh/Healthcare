package com.slokam.healthcare.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

@Entity
public class Treatment implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "fkid20")
	private Doctor doctor;
	@ManyToOne()
	@JoinColumn(name = "fkid21")
	private Visiting visiting;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Visiting getVisiting() {
		return visiting;
	}

	public void setVisiting(Visiting visiting) {
		this.visiting = visiting;
	}
}