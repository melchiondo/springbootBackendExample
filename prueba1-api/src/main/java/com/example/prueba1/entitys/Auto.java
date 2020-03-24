package com.example.prueba1.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="autos")
public class Auto {
	
	@Id
	@Column(name="patente")
	private String patente;
	
	@Column(name="nroMotor")
	private String nroMotor;
	
	@Column(name="nroChasis")
	private String nroChasis;
	
	@Column(name="marca")
	private String marca;
	
	@Column(name="modelo")
	private String modelo;
	
	@Column(name="anio")
	private String anio;
	
	@Column(name="color")
	private String color;
	
	
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getNroMotor() {
		return nroMotor;
	}
	public void setNroMotor(String nroMotor) {
		this.nroMotor = nroMotor;
	}
	public String getNroChasis() {
		return nroChasis;
	}
	public void setNroChasis(String nroChasis) {
		this.nroChasis = nroChasis;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
