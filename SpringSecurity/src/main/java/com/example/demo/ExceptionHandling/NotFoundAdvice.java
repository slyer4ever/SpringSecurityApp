package com.example.demo.ExceptionHandling;


import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.Exception.CoursNotFound;
import com.example.demo.Exception.EtudiantNotFound;

@ControllerAdvice
public class NotFoundAdvice {
	

	
	@ResponseBody
	@ExceptionHandler(EtudiantNotFound.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	
	public String etudiantNotFoundHandler(EtudiantNotFound ex)
	{
		return ex.getMessage();
		
		//return new ResponseEntity<EtudiantNotFound>(ex, HttpStatus.OK);
		
	}
	
	
	
	@ResponseBody
	@ExceptionHandler(CoursNotFound.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	
	public String coursNotFoundHandler(CoursNotFound ex)
	{
		return ex.getMessage();
	}
	
	
	

	
	

}
