package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EtudiantRepository;
import com.example.demo.dao.Etudiant;

@Service
public class ServiceStudent {
	
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	
	public List<Etudiant> FindAllEtudiants(){
		
		return etudiantRepository.findAll();
		
	}

}
