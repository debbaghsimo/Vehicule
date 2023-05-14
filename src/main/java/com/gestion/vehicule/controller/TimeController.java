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

import com.gestion.vehicule.model.Time;
import com.gestion.vehicule.repository.TimeRepository;

@RestController
@RequestMapping(path="/time")
@CrossOrigin("*")
public class TimeController {
	@Autowired
	TimeRepository VR;
	
	@GetMapping(value="")
	public List<Time> Index() {
	  List<Time> Times = VR.findAll();
	  return Times;
	}
	
	@GetMapping(value="/{id}")
	public Time GetTime(@PathVariable Long id) {
		Time V = VR.findById(id).orElse(null);
		return V;
		
	}
	
	@PostMapping(value="/add")
	public Time Create(@RequestBody Time NewTime) {
		Time V = VR.save(NewTime);
		return V;
	}
	
	@PutMapping(value="/update")
	public Time Update(@RequestBody Time NewTime) {
		Time V = VR.save(NewTime);
		return V;
	}

	@DeleteMapping(value="/{id}")
	public void Delete(@PathVariable Long id) {
		VR.deleteById(id);
	}
}
