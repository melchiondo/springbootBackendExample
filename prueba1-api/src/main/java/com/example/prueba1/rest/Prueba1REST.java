package com.example.prueba1.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba1.dao.AutosDAO;
import com.example.prueba1.entitys.Auto;

@RestController
@RequestMapping("autos")
public class Prueba1REST {

	@Autowired
	private AutosDAO autosDAO;

	//////////////////////////////////////////////////////
	// UpdateAuto - modificación de auto --> PUT /autos //
	//////////////////////////////////////////////////////
	@PutMapping
	public ResponseEntity<Auto> deleteAuto(@RequestBody Auto auto) {
		Optional<Auto> optionalAuto = autosDAO.findById(auto.getPatente());
		if (optionalAuto.isPresent()) {
			Auto updateAuto = optionalAuto.get();
			updateAuto.setAnio(auto.getAnio());
			updateAuto.setColor(auto.getColor());
			updateAuto.setMarca(auto.getMarca());
			updateAuto.setModelo(auto.getModelo());
			updateAuto.setNroChasis(auto.getNroChasis());
			updateAuto.setNroMotor(auto.getNroMotor());
			autosDAO.save(updateAuto);
			return ResponseEntity.ok(updateAuto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	///////////////////////////////////////////////////////////
	// DeleteAuto - Baja de auto --> DELETE /autos/{patente} //
	///////////////////////////////////////////////////////////
	@DeleteMapping(value = "{patente}")
	public ResponseEntity<Void> deleteAuto(@PathVariable("patente") String patente) {
		autosDAO.deleteById(patente);
		return ResponseEntity.ok(null);
	}
	
	/////////////////////////////////////////////////////
	// createAuto - Alta de nuevo auto --> POST /autos //
	/////////////////////////////////////////////////////
	@PostMapping
	public ResponseEntity<Auto> createAuto(@RequestBody Auto auto) {
		Auto newAuto = autosDAO.save(auto);
		return ResponseEntity.ok(newAuto);
	}

	//////////////////////////////////////////////////////////////////////
	// getAutoById - Responde auto por patente --> GET /autos/{patente} //
	//////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "{patente}")
	public ResponseEntity<Auto> getAutoById(@PathVariable("patente") String patente) {
		Optional<Auto> optionalAuto = autosDAO.findById(patente);
		if (optionalAuto.isPresent()) {
			return ResponseEntity.ok(optionalAuto.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	///////////////////////////////////////////////////////
	// getAuto - Responde todos los autos --> GET /autos //
	///////////////////////////////////////////////////////
	@GetMapping
	public ResponseEntity<List<Auto>> getAuto() {
		List<Auto> autos = autosDAO.findAll();
		return ResponseEntity.ok(autos);

// array de autos estático
// .......................		
//		Auto auto1 = new Auto();
//		auto1.setAnio("2009");
//		auto1.setColor("negro");
//		auto1.setMarca("Peugeot");
//		auto1.setModelo("207 Compact");
//		auto1.setNroChasis("nrochasis1");
//		auto1.setNroMotor("nromotor1");
//		auto1.setPatente("HWG726");
//		
//		Auto auto2 = new Auto();
//		auto2.setAnio("2020");
//		auto2.setColor("blanco");
//		auto2.setMarca("Ford");
//		auto2.setModelo("Focus");
//		auto2.setNroChasis("nrochasis2");
//		auto2.setNroMotor("nromotor2");
//		auto2.setPatente("AE3344VV");
//		
//		List<Auto> autos = new ArrayList<Auto>();
//		autos.add(auto1);
//		autos.add(auto2);
//		
//		return ResponseEntity.ok(autos);
	}

//	@GetMapping
//	public String Hello() {
//		return "Esta API gestiona AUTOS!";
//	}

}
