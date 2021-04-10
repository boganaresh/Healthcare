package com.slokam.healthcare.pojo;

import java.util.Date;

public class PatientSearchPojo {

	private String name;
	private Long phone;
	private Date fromDate;
	private Date toDate;
	private Integer pageNo;
	private Integer pageSize;
	private Integer startingAge;
	private Integer endingAge;
	private Integer gender;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getStartingAge() {
		return startingAge;
	}
	public void setStartingAge(Integer startingAge) {
		this.startingAge = startingAge;
	}
	public Integer getEndingAge() {
		return endingAge;
	}
	public void setEndingAge(Integer endingAge) {
		this.endingAge = endingAge;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
}
