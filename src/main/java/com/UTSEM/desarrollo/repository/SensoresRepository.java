package com.UTSEM.desarrollo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UTSEM.desarrollo.model.Sensores;

import jakarta.persistence.Id;

public interface SensoresRepository extends JpaRepository<Sensores, Long> {
    Sensores findTopByOrderByIdDesc();

    
    // Consultas para obtener el valor máximo
    @Query("SELECT MAX(s.humedad) FROM Sensores s")
    Double findMaxHumedad();

    @Query("SELECT MAX(s.temperatura) FROM Sensores s")
    Double findMaxTemperatura();

    @Query("SELECT MAX(s.particulas) FROM Sensores s")
    Double findMaxParticulas();

    // Consultas para obtener el valor mínimo
    @Query("SELECT MIN(s.humedad) FROM Sensores s")
    Double findMinHumedad();

    @Query("SELECT MIN(s.temperatura) FROM Sensores s")
    Double findMinTemperatura();

    @Query("SELECT MIN(s.particulas) FROM Sensores s")
    Double findMinParticulas();

    // Consultas para obtener el valor promedio
    @Query("SELECT AVG(s.humedad) FROM Sensores s")
    Double findAvgHumedad();

    @Query("SELECT AVG(s.temperatura) FROM Sensores s")
    Double findAvgTemperatura();

    @Query("SELECT AVG(s.particulas) FROM Sensores s")
    Double findAvgParticulas();

    // Consulta para obtener la última vez que se registró una llama
    @Query("SELECT s.famaA FROM Sensores s ORDER BY s.id DESC LIMIT 1")
    Double findUltimaFamaA();

}
