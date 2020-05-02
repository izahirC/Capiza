package com.cenfotec.proyectoApi.service;



import java.util.List;
import java.util.Optional;

import com.cenfotec.proyectoApi.domain.Paciente;

public interface PacienteService {

	public Paciente savePaciente(Paciente newPaciente);
	public List<Paciente> getAllPacientes();
	public Optional<Paciente> getById(String id);
	public void deleteById(String id);
	public Paciente getByCedula(String cedula);
	
}