package com.gestion.vehicule.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="engine_dim")
public class Engine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false)
	private double enginePower;

	@Column(nullable=false)
	private int capacity;

	@Column(nullable=false)
	private String engineType;

	@Column(nullable=false)
	private double maxPower;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "engine",cascade = CascadeType.ALL)
	private List<Consommation> consommations;
	
	
}