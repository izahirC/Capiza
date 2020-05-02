package com.cenfotec.proyectoApi.service;

import java.util.List;
import java.util.Optional;

import com.cenfotec.proyectoApi.domain.Clinica;


public interface ClinicaService {

	public Clinica saveClinica(Clinica newClinica);
	public List<Clinica> getAllClinicas();
	public Optional<Clinica> getById(String id);
	public void deleteById(String id);
	
	
}