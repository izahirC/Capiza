package com.cenfotec.proyecto.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.proyecto.domain.Paciente;
import com.cenfotec.proyecto.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService {
	@Autowired
	PacienteRepository pacienteRepo;

	@Override
	public Paciente savePaciente(Paciente newProducto) {
		return pacienteRepo.save(newProducto);
		
	}

	@Override
	public List<Paciente> getAllPacientes() {
		List<Paciente> listaPacientes=(List<Paciente>) pacienteRepo.findAll();
		return listaPacientes;
	}

	@Override
	public Optional<Paciente> getById(String id) {
		Optional<Paciente> paciente = pacienteRepo.findById(id);
		return paciente;
	}

	

}