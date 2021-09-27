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

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController
{
	     @RequestMapping(value={"","/","/get"})
         public ResponseEntity<String> getEmployeePayrollData()
         {
        	 return new ResponseEntity<String>("Get call success",HttpStatus.OK);
         }
	     
	     @GetMapping("/get/{empId}")
         public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId)
         {
        	 return new ResponseEntity<String>("Get call success for id"+empId,HttpStatus.OK);
         }
	     
	     @PostMapping("/create")
         public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDto empPayrollDto)
         {
        	 return new ResponseEntity<String>("created employee payroll data for "+empPayrollDto,HttpStatus.OK);
         }
	     @PutMapping("/update")
         public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDto empPayrollDto)
         {
        	 return new ResponseEntity<String>("Updated employee payroll data for "+empPayrollDto,HttpStatus.OK);
         }
	     @DeleteMapping("/get/{empId}")
         public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId)
         {
        	 return new ResponseEntity<String>("Delete call success for "+empId,HttpStatus.OK);
         }
}
