package com.slokam.healthcare.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

@Entity
public class Patient implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Integer age;
	private Date registeredDate;
	@ManyToOne()
	@JoinColumn(name = "fkid17")
	private Gender gender;
	private Long phone;
	private String email;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", registeredDate=" + registeredDate
				+ ", gender=" + gender + ", phone=" + phone + ", email=" + email + "]";
	}
}