package com.gestion.vehicule.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Vehicule implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6744104147954225953L;

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
	
	@Column(nullable=false)
	private int nmbofseat;

	@Column(nullable=false)
	private String height;	

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "vehicule",cascade = CascadeType.ALL)
	private List<Consommation> consommations;
	

	
}
