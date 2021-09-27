package com.bridgelabz.employeepayrollapp.controllers;


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

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController
{
	     @RequestMapping(value={"","/","/get"})
         public ResponseEntity<ResponseDTO> getEmployeePayrollData()
         {
	    	 EmployeePayrollData emp=null;
	    	 emp=new EmployeePayrollData(1,new EmployeePayrollDto("Vaibhav",50000));
	    	 ResponseDTO respDTO=new ResponseDTO("Get call successful",emp);
        	 return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
         }
	     
	     @GetMapping("/get/{empId}")
         public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId)
         {
	    	 EmployeePayrollData emp=null;
	    	 emp=new EmployeePayrollData(1,new EmployeePayrollDto("Ajay",70000));
	    	 ResponseDTO respDTO=new ResponseDTO("Get call Id successful",emp);
        	 return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
         }
	     
	     @PostMapping("/create")
         public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDto empPayrollDto)
         {
	    	 EmployeePayrollData emp=null;
	    	 emp=new EmployeePayrollData(1,empPayrollDto);
	    	 ResponseDTO respDTO=new ResponseDTO("created employee payroll data successful",emp);
        	 return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
         }
	     
	     @PutMapping("/update")
         public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDto empPayrollDto)
         {
	    	 EmployeePayrollData emp=null;
	    	 emp=new EmployeePayrollData(1,empPayrollDto);
	    	 ResponseDTO respDTO=new ResponseDTO("Updated employee payroll data successfully",emp);
        	 return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
         }
	     
	     @DeleteMapping("/get/{empId}")
         public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId)
         {
	    	 ResponseDTO respDTO=new ResponseDTO("Deleted successfully","Deleted id = "+empId);
        	 return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
         }
}
