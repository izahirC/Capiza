package com.cenfotec.proyecto.repository;


import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.cenfotec.proyecto.domain.Caso;


@EnableScan
public interface CasoRepository extends CrudRepository<Caso, String> {
}