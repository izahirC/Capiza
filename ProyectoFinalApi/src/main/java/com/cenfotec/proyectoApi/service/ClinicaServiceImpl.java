package com.cenfotec.proyectoApi.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.proyectoApi.domain.Clinica;
import com.cenfotec.proyectoApi.repository.ClinicaRepository;

@Service
public class ClinicaServiceImpl implements ClinicaService {
	@Autowired
	ClinicaRepository clinicaRepo;

	@Override
	public Clinica saveClinica(Clinica newClinica) {
		return clinicaRepo.save(newClinica);
		
	}

	@Override
	public List<Clinica> getAllClinicas() {
		List<Clinica> listaClinicas=(List<Clinica>) clinicaRepo.findAll();
		return listaClinicas;
	}

	@Override
	public Optional<Clinica> getById(String id) {
		Optional<Clinica> clinica = clinicaRepo.findById(id);
		return clinica;
	}

	@Override
	public void deleteById(String id){
		clinicaRepo.deleteById(id);
			
	}

}