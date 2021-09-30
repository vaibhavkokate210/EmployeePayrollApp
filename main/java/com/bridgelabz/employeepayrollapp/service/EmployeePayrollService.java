package com.bridgelabz.employeepayrollapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService
{
	@Autowired
	private EmployeePayrollRepository employeeRepository;
	
	private List<EmployeePayrollData> empList=new ArrayList<>();
	
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return empList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollData(int empId) 
	{
		return empList.stream().filter(empData->empData.getEmpId()==empId).findFirst().orElseThrow(()->new EmployeePayrollException("Employee not found"));
	}

	@Override
	public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDto emp) {
		EmployeePayrollData data;
		data=new EmployeePayrollData(empList.size()+1,emp);
		log.debug("Emp Data :"+data.toString());
		empList.add(data);
		return employeeRepository.save(data);
	}

	@Override
	public void deleteEmployeePayroll(int empId) {
		empList.remove(empId-1);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDto emp) {
		EmployeePayrollData data=this.getEmployeePayrollData(empId);
		data.setName(emp.getName());
		data.setSalary(emp.getSalary());
		empList.set(empId-1, data);
		return data;
	}

}
