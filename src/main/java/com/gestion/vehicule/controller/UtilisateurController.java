package com.gestion.vehicule.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.vehicule.model.Utilisateur;
import com.gestion.vehicule.repository.UtilisateurRepository;

@RestController
@RequestMapping(path="/auth")
@CrossOrigin("*")
public class UtilisateurController {
	@Autowired
	UtilisateurRepository VR;	
	
	@PostMapping(value = "/login")
	public Utilisateur Auth(@RequestBody Utilisateur a){
		Utilisateur Ut = VR.findByUsername(a.getUsername(),a.getPassword()).orElse(null);
		return Ut;
	}
}
