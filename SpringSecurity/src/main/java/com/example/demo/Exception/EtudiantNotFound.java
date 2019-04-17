package com.example.demo.Exception;

public class EtudiantNotFound extends RuntimeException {

	public EtudiantNotFound(Long id)
	{
		
		super("could not find the user with the following id :"+id);
	}
	
	
	
	public EtudiantNotFound(String msg)
	{
		
		super(msg);
	}
	
	
	
}
