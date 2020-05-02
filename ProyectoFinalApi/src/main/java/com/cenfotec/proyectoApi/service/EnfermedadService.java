package com.cenfotec.proyectoApi.service;



import java.util.List;
import java.util.Optional;

import com.cenfotec.proyectoApi.domain.Enfermedad;


public interface EnfermedadService {

	public Enfermedad saveEnfermedad(Enfermedad newEnfermedad);
	public List<Enfermedad> getAllEnfermedades();
	public Optional<Enfermedad> getById(String id);
	public void deleteById(String id);
	
	
}