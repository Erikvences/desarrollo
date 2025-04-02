package com.UTSEM.desarrollo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UTSEM.desarrollo.model.Sensores;

import jakarta.persistence.Id;

public interface SensoresRepository extends JpaRepository<Sensores, Long> {

}
