package com.gestion.vehicule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.vehicule.model.Time;

public interface TimeRepository  extends JpaRepository<Time, Long> {

}
