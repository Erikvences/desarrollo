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
        
        estadisticas.put("maxHumedad", sensoresRepository.findMaxHumedad());
        estadisticas.put("maxTemperatura", sensoresRepository.findMaxTemperatura());
        estadisticas.put("maxParticulas", sensoresRepository.findMaxParticulas());
        
        estadisticas.put("minHumedad", sensoresRepository.findMinHumedad());
        estadisticas.put("minTemperatura", sensoresRepository.findMinTemperatura());
        estadisticas.put("minParticulas", sensoresRepository.findMinParticulas());
        
        estadisticas.put("avgHumedad", sensoresRepository.findAvgHumedad());
        estadisticas.put("avgTemperatura", sensoresRepository.findAvgTemperatura());
        estadisticas.put("avgParticulas", sensoresRepository.findAvgParticulas());
        
        estadisticas.put("ultimaLlama", sensoresRepository.findUltimaFamaA());

        return estadisticas;
    }


}
