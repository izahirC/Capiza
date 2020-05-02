package com.cenfotec.proyectoApi.service;

import java.util.List;
import java.util.Optional;

import com.cenfotec.proyectoApi.domain.Caso;


public interface reporteService {

	public Caso saveCaso(Caso newCaso);
	public List<Caso> getAllCasos();
	public Optional<Caso> getById(String id);
	public void deleteById(String id);
	public List<Caso> reporteCriticos();
	
	
}