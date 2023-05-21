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
	@JoinColumn(name = "vehiculeId")
	private Vehicule vehicule;
	

	@ManyToOne
	@JoinColumn(name = "engineId")
	private Engine engine;
	
	@ManyToOne
	@JoinColumn(name = "opCharId")
	private Opertingchar opertingchar;

	@ManyToOne
	@JoinColumn(name = "timeId")
	private Time time;
	
	@Column(nullable=false)
	private int maxSpeed;
	
	@Column(nullable=false)
	private float cityDrivingFuel;
	
	@Column(nullable=false)
	private float highwayDrivingFuel;
	
	@Column(nullable=true)
	private int cruisingRange;

	
}
