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

import com.gestion.vehicule.model.Engine;
import com.gestion.vehicule.repository.EngineRepository;

@RestController
@RequestMapping(path="/engine")
@CrossOrigin("*")
public class EngineController {
	@Autowired
	EngineRepository VR;
	
	@GetMapping(value="")
	public List<Engine> Index() {
	  List<Engine> Engines = VR.findAll();
	  return Engines;
	}
	
	@GetMapping(value="/{id}")
	public Engine GetEngine(@PathVariable Long id) {
		Engine V = VR.findById(id).orElse(null);
		return V;
		
	}
	
	@PostMapping(value="/add")
	public Engine Create(@RequestBody Engine NewEngine) {
		Engine V = VR.save(NewEngine);
		return V;
	}
	
	@PutMapping(value="/update")
	public Engine Update(@RequestBody Engine NewEngine) {
		Engine V = VR.save(NewEngine);
		return V;
	}

	@DeleteMapping(value="/{id}")
	public void Delete(@PathVariable Long id) {
		VR.deleteById(id);
	}
	
}
