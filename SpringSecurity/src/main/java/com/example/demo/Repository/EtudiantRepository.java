package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{
	


}
