package com.bridgelabz.employeepayrollapp.service;

import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

public interface IEmployeePayrollService 
{
	List<EmployeePayrollData> getEmployeePayrollData();
	
	EmployeePayrollData getEmployeePayrollData(int id);
	
	EmployeePayrollData addEmployeePayrollData(EmployeePayrollDto emp);
	
	void deleteEmployeePayroll(int id);
	
	EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDto emp);
	
	List<EmployeePayrollData> getEmployeeByDepartment(String department);
}
