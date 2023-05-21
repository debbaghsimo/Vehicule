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
import com.gestion.vehicule.model.Opertingchar;
import com.gestion.vehicule.repository.ConsommationRepository;
import com.gestion.vehicule.repository.OpertingcharRepository;

@RestController
@RequestMapping(path="/consommation")
@CrossOrigin("*")
public class ConsommationController {
	@Autowired
	ConsommationRepository VR;
	@Autowired
	OpertingcharRepository VEO;
	
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
        Opertingchar o = VEO.findById(NewConsommation.getOpertingchar().getId()).orElse(null);
        int a = 0;
        NewConsommation.setMaxSpeed(o.getMaxSpeed());
        NewConsommation.setCityDrivingFuel(o.getCityDrivingFuel());
        NewConsommation.setHighwayDrivingFuel(o.getHighwayDrivingFuel());
        if(o.getCruisingRange()!="") {
        	a = Integer.parseInt(o.getCruisingRange().split("to")[1].replaceAll(" ", ""));
        }
        NewConsommation.setCruisingRange(a);
		Consommation V = VR.save(NewConsommation);
		return V;
	}
	
	@PutMapping(value="/update")
	public Consommation Update(@RequestBody Consommation NewConsommation) {
		 Opertingchar o = VEO.findById(NewConsommation.getOpertingchar().getId()).orElse(null);
	        int a = 0;
	        NewConsommation.setMaxSpeed(o.getMaxSpeed());
	        NewConsommation.setCityDrivingFuel(o.getCityDrivingFuel());
	        NewConsommation.setHighwayDrivingFuel(o.getHighwayDrivingFuel());
	        if(o.getCruisingRange()!="") {
	        	a = Integer.parseInt(o.getCruisingRange().split("to")[1].replaceAll(" ", ""));
	        }
	        NewConsommation.setCruisingRange(a);
			Consommation V = VR.save(NewConsommation);
		return V;
	}

	@DeleteMapping(value="/{id}")
	public void Delete(@PathVariable Long id) {
		VR.deleteById(id);
	}
}
