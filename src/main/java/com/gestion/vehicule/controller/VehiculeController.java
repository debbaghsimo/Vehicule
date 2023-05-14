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

import com.gestion.vehicule.model.Vehicule;
import com.gestion.vehicule.repository.VehiculeRepository;

@RestController
@RequestMapping(path="/vehicule")
@CrossOrigin("*")
public class VehiculeController {
	@Autowired
	VehiculeRepository VR;
	
	@GetMapping(value="")
	public List<Vehicule> Index() {
	  List<Vehicule> Vehicules = VR.findAll();
	  return Vehicules;
	}
	
	@GetMapping(value="/{id}")
	public Vehicule GetVehicule(@PathVariable Long id) {
		Vehicule V = VR.findById(id).orElse(null);
		return V;
		
	}
	
	@PostMapping(value="/add")
	public Vehicule Create(@RequestBody Vehicule NewVehicule) {
		Vehicule V = VR.save(NewVehicule);
		return V;
	}
	
	@PutMapping(value="/update")
	public Vehicule Update(@RequestBody Vehicule NewVehicule) {
		Vehicule V = VR.save(NewVehicule);
		return V;
	}

	@DeleteMapping(value="/{id}")
	public void Delete(@PathVariable Long id) {
		VR.deleteById(id);
	}
		
}
