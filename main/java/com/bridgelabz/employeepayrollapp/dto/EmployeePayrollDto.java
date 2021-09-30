package com.bridgelabz.employeepayrollapp.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.ToString;

public @ToString class EmployeePayrollDto 
{
	@Pattern(regexp="^[A-Z]{1}{a-zA-Z\\s}{2,}$",message="Employee name is invalid")
	public String name;
	@Min(value=500,message="Min wage should be more than 500")
	public long salary;
	
	public String gender;
	
	public String startDate;
	
	public String note;
	
	public String profilePic;
	
	public List<String> department;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public List<String> getDepartment() {
		return department;
	}

	public void setDepartment(List<String> department) {
		this.department = department;
	}
	
	
}
