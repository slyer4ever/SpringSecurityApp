package com.example.demo;


import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.Repository.CompteRepository;
import com.example.demo.Repository.CoursesRepository;
import com.example.demo.Repository.EtudiantRepository;
import com.example.demo.dao.Compte;
import com.example.demo.dao.Cours;
import com.example.demo.dao.Etudiant;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner {
	
	@Autowired
	CoursesRepository coursesRepository;
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		 final Logger logger = LoggerFactory.getLogger(this.getClass());
		
		Etudiant e1=new Etudiant(null,"Nidal","Hanif",LocalDate.now(),null);
	
		Etudiant e2=new Etudiant(null,"Jhon","Snow",LocalDate.now(),null);
		
		Cours c1= new Cours(null,"Java",3,e1);
		Cours c2= new Cours(null,"Spring",5,e1);
		
		Compte compte=new Compte("NHA","123","ADMIN",e1);
		compte.setPassword(bCryptPasswordEncoder.encode(compte.getPassword()));
		
		Compte compte2=new Compte("HAN","123","USER",e2);
		compte2.setPassword(bCryptPasswordEncoder.encode(compte2.getPassword()));
		
		
		Compte compte3=new Compte("AAA","123","USER",null);
		compte3.setPassword(bCryptPasswordEncoder.encode(compte3.getPassword()));
		
		
		
		etudiantRepository.save(e1);
		logger.info("Etudiant e1 enregisté"+e1);
		etudiantRepository.save(e2);
		logger.info("Etudiant e2 enregisté"+e2);
		coursesRepository.save(c1);
		coursesRepository.save(c2);
		compteRepository.save(compte);
		compteRepository.save(compte2);
		compteRepository.save(compte3);
		
		
	}

}
