package com.bridgelabz.employeepayrollapp.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.model.ResponseDTO;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController
{
		 @Autowired
		 IEmployeePayrollService service;
		 
		 
	     @RequestMapping(value={"","/","/get"})
         public ResponseEntity<ResponseDTO> getEmployeePayrollData()
         {
	    	 List<EmployeePayrollData> empDataList=null;
	    	 empDataList=service.getEmployeePayrollData();
	    	 ResponseDTO respDTO=new ResponseDTO("Get call successful",empDataList);
        	 return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
         }
	     
	     @GetMapping("/get/{empId}")
         public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId)
         {
	    	 EmployeePayrollData emp=null;
	    	 emp=service.getEmployeePayrollData(empId);
	    	 ResponseDTO respDTO=new ResponseDTO("Get call Id successful",emp);
        	 return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
         }
	     
	     @PostMapping("/create")
         public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDto empPayrollDto)
         {
	    	 EmployeePayrollData emp=null;
	    	 emp=service.addEmployeePayrollData(empPayrollDto);
	    	 ResponseDTO respDTO=new ResponseDTO("created employee payroll data successful",emp);
        	 return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
         }
	     
	     @PutMapping("/update/{empId}")
         public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,@RequestBody EmployeePayrollDto empPayrollDto)
         {
	    	 EmployeePayrollData emp=null;
	    	 emp=service.updateEmployeePayrollData(empId,empPayrollDto);
	    	 ResponseDTO respDTO=new ResponseDTO("Updated employee payroll data successfully",emp);
        	 return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
         }
	     
	     @DeleteMapping("/get/{empId}")
         public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId)
         {
	    	 service.deleteEmployeePayroll(empId);
	    	 ResponseDTO respDTO=new ResponseDTO("Deleted successfully","Deleted id = "+empId);
        	 return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
         }
}
