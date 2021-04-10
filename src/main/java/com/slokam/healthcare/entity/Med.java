package com.slokam.healthcare.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

@Entity
public class Med implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;

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
}