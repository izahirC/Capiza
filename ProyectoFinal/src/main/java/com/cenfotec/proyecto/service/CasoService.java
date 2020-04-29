package com.cenfotec.proyecto.service;

import java.util.List;
import java.util.Optional;

import com.cenfotec.proyecto.domain.Caso;


public interface CasoService {

	public Caso saveCaso(Caso newCaso);
	public List<Caso> getAllCasos();
	public Optional<Caso> getById(String id);

	
	
}