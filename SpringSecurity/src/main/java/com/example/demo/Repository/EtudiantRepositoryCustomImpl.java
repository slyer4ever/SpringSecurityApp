package com.example.demo.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import com.example.demo.dao.Etudiant;

public class EtudiantRepositoryCustomImpl implements EtudiantRepositoryCustom {


	@PersistenceContext private EntityManager em;


	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	

	
	@Override
	public List<Map<Long, Map<String, Object>>> findAllEtudiantJoinCours() {
		
		
		
		CriteriaBuilder builder =  em.getCriteriaBuilder();
		CriteriaQuery<Etudiant> criteriaQuery =builder.createQuery(Etudiant.class);
		Root<Etudiant> root= criteriaQuery.from(Etudiant.class);
		Path<String> Nom_ET =root.<String> get("Nom");
		criteriaQuery.select(root).where(
				builder.or(
				builder.equal(Nom_ET, "Jhon"),
				builder.equal(Nom_ET, "Nidal")
				)
			
				
				);
		
	
	/*	criteriaQuery.select(criteriaQuery.from(Etudiant.class)).where(
				builder.equal(root.get("Nom"), "Jhon")
				
				
				);*/
		return em.createQuery(criteriaQuery).getResultList().stream().map(e->{
			Map<String, Object> mapEtudiant= new LinkedHashMap<String, Object>();
			mapEtudiant.put("Nom",e.getNom());
			mapEtudiant.put("Prenom",e.getPrenom());
			mapEtudiant.put("Date de naissance",e.getDateNaissance());
			mapEtudiant.put("Cours:",e.getCourses());
			
			Map<Long,Map<String, Object>> idMapEtudiant = new LinkedHashMap<Long,Map<String, Object>>();
			idMapEtudiant.put(e.getId_etudiant(),mapEtudiant);
			return idMapEtudiant;
			
		}).collect(Collectors.toList());
		
		
		
		

		/*return  emf.createEntityManager().find(Etudiant.class)
.stream().map(e->{
			Map<String, Object> mapEtudiant= new LinkedHashMap<String, Object>();
			mapEtudiant.put("Nom",e.getNom());
			mapEtudiant.put("Prenom",e.getPrenom());
			mapEtudiant.put("Date de naissance",e.getDateNaissance());
			mapEtudiant.put("Cours:",e.getCourses());
			
			Map<Long,Map<String, Object>> idMapEtudiant = new LinkedHashMap<Long,Map<String, Object>>();
			idMapEtudiant.put(e.getId_etudiant(),mapEtudiant);
			return idMapEtudiant;
			
		}).collect(Collectors.toList());*/
	}

	
	

	
}
