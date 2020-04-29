package com.cenfotec.proyecto.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.proyecto.domain.Enfermedad;
import com.cenfotec.proyecto.repository.EnfermedadRepository;

@Service
public class EnfermedadServiceImpl implements EnfermedadService {
	@Autowired
	EnfermedadRepository enfermedadRepo;

	@Override
	public Enfermedad saveEnfermedad(Enfermedad newEnfermedad) {
		return enfermedadRepo.save(newEnfermedad);
		
	}

	@Override
	public List<Enfermedad> getAllEnfermedades() {
		List<Enfermedad> listaEnfermedades=(List<Enfermedad>) enfermedadRepo.findAll();
		return listaEnfermedades;
	}

	@Override
	public Optional<Enfermedad> getById(String id) {
		Optional<Enfermedad> enfermedad = enfermedadRepo.findById(id);
		return enfermedad;
	}

	

}