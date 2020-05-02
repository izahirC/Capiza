package com.cenfotec.proyectoApi.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.proyectoApi.domain.Paciente;
import com.cenfotec.proyectoApi.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService {
	@Autowired
	PacienteRepository pacienteRepo;

	@Override
	public Paciente savePaciente(Paciente newPaciente) {
		return pacienteRepo.save(newPaciente);
		
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

	@Override
	public void deleteById(String id){
		pacienteRepo.deleteById(id);
			
	}

	@Override
	public Paciente getByCedula(String cedula) {
		List<Paciente> listaPacientes = getAllPacientes();
		Paciente miPaciente= new Paciente();
		for(Paciente paciente : listaPacientes) {
			if(paciente.getCedula()!=null && paciente.getCedula().equals(cedula)) {
				miPaciente= paciente;
			}
		}
		return miPaciente;
	}

}