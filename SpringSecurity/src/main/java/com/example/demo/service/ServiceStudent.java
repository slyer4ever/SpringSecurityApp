package com.example.demo.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CompteRepository;
import com.example.demo.Repository.EtudiantRepository;
import com.example.demo.dao.Compte;
import com.example.demo.dao.Etudiant;

@Service
public class ServiceStudent {
	
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Autowired
	CompteRepository compteRepository;
	
	

	 final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<Etudiant> FindAllEtudiants(){
		
		return etudiantRepository.findAll();
		
	}

	
	public Etudiant SaveStudent(Etudiant et)
	{
		
		
		Etudiant ReturnedEtudiant =etudiantRepository.save(et);
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		

		 if (principal instanceof UserDetails) {
			
			 logger.info("UD");
			 String username = ((UserDetails)principal).getUsername();
			 Compte compte=compteRepository.findById(username).orElse(null);
			 		
						 if(compte==null)
						 {
							 
							 logger.info(compte+"is null");
							
						 }else
						 {
							 
							 logger.info("DONE :   "+et.getPrenom()+"has been assigned to"+compte.getUsername());
							 compte.setEtudiant(et);
							 compteRepository.save(compte);
							 
						 }
			 		
			 
			 logger.info(" Current connected USER  : "+username);
			} else {
				

				
			  try {
				throw new Exception("Compte cannot be bound to the Etudiant :");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
		return ReturnedEtudiant ;
	}
	
	
}
