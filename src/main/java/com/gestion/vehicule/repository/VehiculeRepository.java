package com.gestion.vehicule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.vehicule.model.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

}
