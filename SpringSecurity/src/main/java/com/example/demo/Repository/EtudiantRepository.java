package com.example.demo.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>,EtudiantRepositoryCustom{
	
		@Override
		@Secured("ROLE_ADMIN")
		List<Etudiant> findAll();

	
}
