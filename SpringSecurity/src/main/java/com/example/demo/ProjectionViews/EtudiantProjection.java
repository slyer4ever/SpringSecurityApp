package com.example.demo.ProjectionViews;

import java.util.Collection;

import org.springframework.data.rest.core.config.Projection;
import org.springframework.security.core.GrantedAuthority;

import com.example.demo.dao.Compte;
import com.example.demo.dao.Etudiant;

@Projection(name="EtudiantProjection",types=Etudiant.class)
public interface EtudiantProjection {

	String getNom();
	String getPrenom();

	
	
}
