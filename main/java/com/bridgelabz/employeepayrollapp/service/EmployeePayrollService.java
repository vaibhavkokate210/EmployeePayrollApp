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
		return employeeRepository
				.findById(empId)
				.orElseThrow(()->new EmployeePayrollException("Employee with employeeId "+
				  empId+" does not exists..."));
	}

	@Override
	public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDto emp) {
		EmployeePayrollData data=null;
		data=new EmployeePayrollData(emp);
		log.debug("Emp Data :"+data.toString());
		return employeeRepository.save(data);
	}

	@Override
	public void deleteEmployeePayroll(int empId) {
		EmployeePayrollData empData=this.getEmployeePayrollData(empId);
		employeeRepository.delete(empData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDto emp) {
		EmployeePayrollData data=this.getEmployeePayrollData(empId);
		data.updateEmployeePayrollData(emp);
		return employeeRepository.save(data);
	}

}
