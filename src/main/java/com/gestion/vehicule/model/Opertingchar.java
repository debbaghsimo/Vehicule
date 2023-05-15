package com.gestion.vehicule.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@Table(name="opertingchar_dim")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Opertingchar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false)
	private int cruisingRange;
	
	@Column(nullable=false)
	private int fuelTankCapacity;
	
	@Column(nullable=false)
	private String fuel;
	
	@Column(nullable=false)
	private float acceleration;
	
	@Column(nullable=false)
	private int maxSpeed;
	
	@Column(nullable=false)
	private float cityDrivingFuel;
	
	@Column(nullable=false)
	private float highwayDrivingFuel;
	
	@Column(nullable=false)
	private float mixedDrivingFuel;
	
	@Column(nullable=false)
	private double payload;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "opertingchar",cascade = CascadeType.ALL)
	private List<Consommation> consommations;

}
