package com.UTSEM.desarrollo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UTSEM.desarrollo.model.Sensores;
import com.UTSEM.desarrollo.repository.SensoresRepository;
;

@RestController
@RequestMapping("sensores")
public class SensoresController {
	
	@Autowired
	SensoresRepository sensoresRepository;
	
	@PostMapping("guardar")
	public String guardar(@RequestBody Sensores lectura) {
		lectura.setFecha(LocalDateTime.now());
			sensoresRepository.save(lectura);
			return "Lectura guardada exitosamente";
	}
	
	
	@GetMapping("listar")
	public List<Sensores> listar() {
		return sensoresRepository.findAll();
	}
	
	@GetMapping("ultimo")
    public Sensores obtenerUltimoProducto() {
        return sensoresRepository.findTopByOrderByIdDesc();
    }

	@GetMapping("estadisticas")
    public Map<String, Double> getEstadisticas() {
        Map<String, Double> estadisticas = new HashMap<>();
        
        estadisticas.put("maxHumedad", sensorDataRepository.findMaxHumedad());
        estadisticas.put("maxTemperatura", sensorDataRepository.findMaxTemperatura());
        estadisticas.put("maxParticulas", sensorDataRepository.findMaxParticulas());
        
        estadisticas.put("minHumedad", sensorDataRepository.findMinHumedad());
        estadisticas.put("minTemperatura", sensorDataRepository.findMinTemperatura());
        estadisticas.put("minParticulas", sensorDataRepository.findMinParticulas());
        
        estadisticas.put("avgHumedad", sensorDataRepository.findAvgHumedad());
        estadisticas.put("avgTemperatura", sensorDataRepository.findAvgTemperatura());
        estadisticas.put("avgParticulas", sensorDataRepository.findAvgParticulas());
        
        estadisticas.put("ultimaLlama", sensorDataRepository.findUltimaFamaA());

        return estadisticas;
    }


}
