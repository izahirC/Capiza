package com.cenfotec.proyecto.service;



import java.util.List;
import java.util.Optional;

import com.cenfotec.proyecto.domain.Paciente;

public interface PacienteService {

	public Paciente savePaciente(Paciente newPaciente);
	public List<Paciente> getAllPacientes();
	public Optional<Paciente> getById(String id);

	
	
}