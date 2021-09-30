package com.bridgelabz.employeepayrollapp.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.employeepayrollapp.model.ResponseDTO;

@ControllerAdvice
public class EmployeePayrollExceptionHandler
{
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> HandleMethodArgumentNotValidException(MethodArgumentNotValidException exception)
	{
		List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
		List<String> errMsg=errorList.stream().map(objErr->objErr.getDefaultMessage()).collect(Collectors.toList());
		ResponseDTO responseDTO=new ResponseDTO("Exception while processing REST request",errMsg);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
		
	}
}
