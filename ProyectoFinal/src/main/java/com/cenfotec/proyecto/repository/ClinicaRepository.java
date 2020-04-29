package com.cenfotec.proyecto.repository;


import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.cenfotec.proyecto.domain.Clinica;


@EnableScan
public interface ClinicaRepository extends CrudRepository<Clinica, String> {
}