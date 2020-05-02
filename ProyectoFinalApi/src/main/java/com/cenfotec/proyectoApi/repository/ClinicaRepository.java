package com.cenfotec.proyectoApi.repository;


import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.cenfotec.proyectoApi.domain.Clinica;


@EnableScan
public interface ClinicaRepository extends CrudRepository<Clinica, String> {
}