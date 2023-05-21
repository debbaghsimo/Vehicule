package com.gestion.vehicule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.vehicule.model.Consommation;
import com.gestion.vehicule.model.Vehicule;
import com.gestion.vehicule.repository.ConsommationRepository;
import com.gestion.vehicule.repository.VehiculeRepository;

@RestController
@RequestMapping(path="/consommation")
@CrossOrigin("*")
public class ConsommationController {
	@Autowired
	ConsommationRepository VR;
	@Autowired
	VehiculeRepository VER;
	
	@GetMapping(value="")
	public List<Consommation> Index() {
	  List<Consommation> Consommations = VR.findAll();
	  return Consommations;
	}
	
	@GetMapping(value="/{id}")
	public Consommation GetConsommation(@PathVariable Long id) {
		Consommation V = VR.findById(id).orElse(null);
		return V;
		
	}
	
	@PostMapping(value="/add")
	public Consommation Create(@RequestBody Consommation NewConsommation) {
		
		Consommation V = VR.save(NewConsommation);
		return V;
	}
	
	@PutMapping(value="/update")
	public Consommation Update(@RequestBody Consommation NewConsommation) {
		Consommation V = VR.save(NewConsommation);
		return V;
	}

	@DeleteMapping(value="/{id}")
	public void Delete(@PathVariable Long id) {
		VR.deleteById(id);
	}
}
