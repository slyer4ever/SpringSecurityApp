package com.example.demo.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity

@Data
@EntityListeners(AuditingEntityListener.class)
public class Compte extends Auditable implements UserDetails, Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String username;
	private String password;
	private String role;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_etudiant", referencedColumnName = "id_etudiant")

	private Etudiant etudiant;
	
	
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	return Arrays.asList(new SimpleGrantedAuthority("ROLE_"+role));
	}
	@Override
	public boolean isAccountNonExpired() {
	return true;
	}
	@Override
	public boolean isAccountNonLocked() {
	return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
	return true;
	}
	@Override
	public boolean isEnabled() {
	return true;
	}
	
	
	
	

}
