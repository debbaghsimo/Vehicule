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
@Table(name="time_dim")
public class Time implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4967326735829656804L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private int month_num; 

	@Column(nullable=false)
	private int yearGeneration;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "time",cascade = CascadeType.ALL)
	private List<Consommation> consommations;
}
