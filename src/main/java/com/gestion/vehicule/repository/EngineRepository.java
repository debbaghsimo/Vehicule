package com.gestion.vehicule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.vehicule.model.Engine;


public interface EngineRepository  extends JpaRepository<Engine, Long> {

}
