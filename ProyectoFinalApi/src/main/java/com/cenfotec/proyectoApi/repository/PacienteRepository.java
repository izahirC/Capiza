package com.cenfotec.proyectoApi.repository;


import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.cenfotec.proyectoApi.domain.Paciente;

@EnableScan
public interface PacienteRepository extends CrudRepository<Paciente, String> {
}