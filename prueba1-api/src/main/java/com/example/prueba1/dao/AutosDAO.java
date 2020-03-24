package com.example.prueba1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prueba1.entitys.Auto;

public interface AutosDAO extends JpaRepository<Auto, String>{
	
}
