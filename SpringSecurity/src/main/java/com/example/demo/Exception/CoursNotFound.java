package com.example.demo.Exception;

public class CoursNotFound  extends RuntimeException{
	
	
	public CoursNotFound(Long id) {
		
		super("Cours with the followinf ID "+id+ " has not been found !");
		
	}

}
