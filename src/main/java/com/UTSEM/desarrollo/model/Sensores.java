package com.UTSEM.desarrollo.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sensores {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long Id;
	@Column
	Float Temperatura;
	@Column
	Float Humedad;
	@Column
	Integer FamaD;
	@Column
	Integer FamaA;
	@Column
	Integer MQ135;
	@Column
	@JsonFormat(pattern = "HH:mm dd/MM/YY")
	LocalDateTime fecha;
	
	
	
	
	
	public Integer getFamaD() {
		return FamaD;
	}
	public void setFamaD(Integer famaD) {
		FamaD = famaD;
	}
	public Integer getFamaA() {
		return FamaA;
	}
	public void setFamaA(Integer famaA) {
		FamaA = famaA;
	}
	public Integer getMQ135() {
		return MQ135;
	}
	public void setMQ135(Integer mQ135) {
		MQ135 = mQ135;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Float getTemperatura() {
		return Temperatura;
	}
	public void setTemperatura(Float temperatura) {
		Temperatura = temperatura;
	}
	public Float getHumedad() {
		return Humedad;
	}
	public void setHumedad(Float humedad) {
		Humedad = humedad;
	}
	
	///
	

}
