package com.example.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.CoursNotFound;
import com.example.demo.Exception.EtudiantNotFound;
import com.example.demo.Repository.CoursesRepository;
import com.example.demo.Repository.EtudiantRepository;
import com.example.demo.dao.Cours;
import com.example.demo.dao.Etudiant;

@Service
public class CoursService {
	
	
	@Autowired
	CoursesRepository coursesRepository;
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	
	 final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Cours AffecterEtudiantToCours(Long id_etudiant,Long id_cours)
	{
		
		Etudiant e=etudiantRepository.findById(id_etudiant).orElseThrow(()-> new EtudiantNotFound(id_etudiant));
		Cours c= coursesRepository.findById(id_etudiant).orElseThrow(()-> new CoursNotFound(id_cours));
		
		if(e.getCourses().contains(c))
		{
		
			
			throw new EtudiantNotFound("L'etudiant est deja inscrit à ce cours");
		
			
			
		}else
		{
			
			logger.info("L'etudiant a été affecté a ce cours");
			
			Cours coursTMP= new Cours(null, c.getNom_cours(), c.getDuree_cours(), e);
			return coursesRepository.save(coursTMP);
			
			
			
		}
		
	}
	

}
