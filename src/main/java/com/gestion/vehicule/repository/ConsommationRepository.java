package com.gestion.vehicule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.vehicule.model.Consommation;

public interface ConsommationRepository  extends JpaRepository<Consommation, Long> {
}
