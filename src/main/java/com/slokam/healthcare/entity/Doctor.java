package com.slokam.healthcare.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

@Entity
public class Doctor implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String spec;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}
}