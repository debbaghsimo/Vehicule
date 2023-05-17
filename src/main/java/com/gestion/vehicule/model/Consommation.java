package com.gestion.vehicule.model;



import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="consommation_fact")
public class Consommation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3872528249799028388L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "vehicule_id")
	private Vehicule vehicule;
	

	@ManyToOne
	@JoinColumn(name = "engine_id")
	private Engine engine;
	
	@ManyToOne
	@JoinColumn(name = "opch_id")
	private Opertingchar opertingchar;

	@ManyToOne
	@JoinColumn(name = "time_id")
	private Time time;
	
	@Column(nullable=false)
	private String modele;
	
	@Column(nullable=false)
	private String serie;
	
	@Column(nullable=false)
	private int speed;
	
	@Column(nullable=false)
	private float taux_consomationcity;
	
	@Column(nullable=false)
	private float taux_consomationhighway;
	
	@Column(nullable=true)
	private int moyen_distanceParcours;
	
	@Column(nullable=false)
	private float mixed_consommation;
	
}
