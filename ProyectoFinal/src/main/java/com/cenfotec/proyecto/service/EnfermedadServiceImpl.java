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
	EnfermedadRepository pacienteRepo;

	@Override
	public Enfermedad saveEnfermedad(Enfermedad newEnfermedad) {
		return pacienteRepo.save(newEnfermedad);
		
	}

	@Override
	public List<Enfermedad> getAllEnfermedades() {
		List<Enfermedad> listaEnfermedads=(List<Enfermedad>) pacienteRepo.findAll();
		return listaEnfermedads;
	}

	@Override
	public Optional<Enfermedad> getById(String id) {
		Optional<Enfermedad> enfermedad = pacienteRepo.findById(id);
		return enfermedad;
	}

	

}