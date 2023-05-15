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
@Table(name="vehicule_dim")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Vehicule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false)
	private String modele;
	
	@Column(nullable=false)
	private String generation;

	@Column(nullable=false)
	private String serie;
	

	@Column(nullable=false)
	private String gearboxtype;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "vehicule",cascade = CascadeType.ALL)
	private List<Consommation> consommations;
	

	@Column(nullable=false)
	private int nmbofseat;

	@Column(nullable=false)
	private String height;
}
