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

import com.gestion.vehicule.model.Opertingchar;
import com.gestion.vehicule.repository.OpertingcharRepository;

@RestController
@RequestMapping(path="/operting")
@CrossOrigin("*")
public class OpertingcharController {
	@Autowired
	OpertingcharRepository VR;
	
	@GetMapping(value="")
	public List<Opertingchar> Index() {
	  List<Opertingchar> Opertingchars = VR.findAll();
	  return Opertingchars;
	}
	
	@GetMapping(value="/{id}")
	public Opertingchar GetOpertingchar(@PathVariable Long id) {
		Opertingchar V = VR.findById(id).orElse(null);
		return V;
		
	}
	
	@PostMapping(value="/add")
	public Opertingchar Create(@RequestBody Opertingchar NewOpertingchar) {
		Opertingchar V = VR.save(NewOpertingchar);
		return V;
	}
	
	@PutMapping(value="/update")
	public Opertingchar Update(@RequestBody Opertingchar NewOpertingchar) {
		Opertingchar V = VR.save(NewOpertingchar);
		return V;
	}

	@DeleteMapping(value="/{id}")
	public void Delete(@PathVariable Long id) {
		VR.deleteById(id);
	}
	
}
