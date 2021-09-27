package com.bridgelabz.employeepayrollapp.dto;

public class EmployeePayrollDto 
{
	public String name;
	public long salary;
	public EmployeePayrollDto(String name, long salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeePayrollDto [name=" + name + ", salary=" + salary + "]";
	}
	
	
}
