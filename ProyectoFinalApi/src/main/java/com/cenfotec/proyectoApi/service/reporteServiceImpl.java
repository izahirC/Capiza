package com.cenfotec.proyectoApi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.proyectoApi.domain.Caso;
import com.cenfotec.proyectoApi.domain.Clinica;
import com.cenfotec.proyectoApi.domain.Enfermedad;
import com.cenfotec.proyectoApi.domain.Paciente;
import com.cenfotec.proyectoApi.repository.CasoRepository;
import com.cenfotec.proyectoApi.repository.ClinicaRepository;
import com.cenfotec.proyectoApi.repository.EnfermedadRepository;
import com.cenfotec.proyectoApi.repository.PacienteRepository;

@Service
public class reporteServiceImpl implements reporteService {
	@Autowired
	CasoRepository casoRepo;
	@Autowired
	ClinicaRepository clinicaRepo;
	@Autowired
	EnfermedadRepository enfermedadRepo;
	@Autowired
	PacienteRepository pacienteRepo;

	@Override
	public Caso saveCaso(Caso newCaso) {
		Date date = new Date();
		newCaso.setFecha(date);
		return casoRepo.save(newCaso);

	}

	@Override
	public List<Caso> getAllCasos() {
		List<Caso> listaCasos = (List<Caso>) casoRepo.findAll();
		return listaCasos;
	}

	@Override
	public Optional<Caso> getById(String id) {
		Optional<Caso> caso = casoRepo.findById(id);
		return caso;
	}

	@Override
	public void deleteById(String id) {
		casoRepo.deleteById(id);

	}

	@Override
	public List<Caso> reporteCriticos() {
		List<Caso> listaCasos = (List<Caso>) casoRepo.findAll();
		List<Paciente> listaPacientes = (List<Paciente>) pacienteRepo.findAll();
		List<Clinica> listaClinicas = (List<Clinica>) clinicaRepo.findAll();
		List<Enfermedad> listaEnfermedades = (List<Enfermedad>) enfermedadRepo.findAll();
		List<Caso> Criticos=new ArrayList<>();
		for (Caso caso : listaCasos) {
			if (caso.getEstado() == Caso.Estado.CRITICO) {
				Optional<Paciente> paciente=pacienteRepo.findById(caso.getPaciente());
				if(paciente.isPresent()) {
					caso.setMiPaciente(paciente.get());
				}
				Optional<Clinica> clinica=clinicaRepo.findById(caso.getClinica());
				if(clinica.isPresent()) {
					caso.setMiClinica(clinica.get());
				}
				Optional<Enfermedad> enfermedad=enfermedadRepo.findById(caso.getEnfermedad());
				if(enfermedad.isPresent()) {
					caso.setMiEnfermedad(enfermedad.get());
				}
				Criticos.add(caso);
			}
		}
		return Criticos;
	}
	
	@Override
	public List<Caso> reporteCerrados() {
		List<Caso> listaCasos = (List<Caso>) casoRepo.findAll();
		List<Paciente> listaPacientes = (List<Paciente>) pacienteRepo.findAll();
		List<Clinica> listaClinicas = (List<Clinica>) clinicaRepo.findAll();
		List<Enfermedad> listaEnfermedades = (List<Enfermedad>) enfermedadRepo.findAll();
		List<Caso> Cerrados=new ArrayList<>();
		for (Caso caso : listaCasos) {
			if (caso.getEstado() == Caso.Estado.CERRADO) {
				Optional<Paciente> paciente=pacienteRepo.findById(caso.getPaciente());
				if(paciente.isPresent()) {
					caso.setMiPaciente(paciente.get());
				}
				Optional<Clinica> clinica=clinicaRepo.findById(caso.getClinica());
				if(clinica.isPresent()) {
					caso.setMiClinica(clinica.get());
				}
				Optional<Enfermedad> enfermedad=enfermedadRepo.findById(caso.getEnfermedad());
				if(enfermedad.isPresent()) {
					caso.setMiEnfermedad(enfermedad.get());
				}
				Cerrados.add(caso);
			}
		}
		return Cerrados;
	}
	
	@Override
	public List<Caso> reporteMujeres() {
		List<Caso> listaCasos = (List<Caso>) casoRepo.findAll();
		List<Paciente> listaPacientes = (List<Paciente>) pacienteRepo.findAll();
		List<Clinica> listaClinicas = (List<Clinica>) clinicaRepo.findAll();
		List<Enfermedad> listaEnfermedades = (List<Enfermedad>) enfermedadRepo.findAll();
		List<Caso> Mujeres=new ArrayList<>();
		for (Caso caso : listaCasos) {
			if (caso.getMiPaciente().getGenero() == Paciente.Genero.FEMENINO) {
				Optional<Paciente> paciente=pacienteRepo.findById(caso.getPaciente());
				if(paciente.isPresent()) {
					caso.setMiPaciente(paciente.get());
				}
				Optional<Clinica> clinica=clinicaRepo.findById(caso.getClinica());
				if(clinica.isPresent()) {
					caso.setMiClinica(clinica.get());
				}
				Optional<Enfermedad> enfermedad=enfermedadRepo.findById(caso.getEnfermedad());
				if(enfermedad.isPresent()) {
					caso.setMiEnfermedad(enfermedad.get());
				}
				Mujeres.add(caso);
			}
		}
		return Mujeres;
	}

}
