package com.gestion.vehicule.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestion.vehicule.model.Utilisateur;


public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Long> {
	
	@Query("Select a from Utilisateur a WHERE a.username=:username and a.password=:password")
	Optional<Utilisateur> findByUsername(@Param("username") String username,@Param("password") String password);
	
}
