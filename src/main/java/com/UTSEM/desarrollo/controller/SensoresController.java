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
		return sensoresRepository.findAll().reversed();
	}
	
	@GetMapping("ultimo")
    public Sensores obtenerUltimoProducto() {
        return sensoresRepository.findTopByOrderByIdDesc();
    }


}
