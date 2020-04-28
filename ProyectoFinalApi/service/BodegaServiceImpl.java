package com.cenfotec.examen.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cenfotec.examen.domain.Bodega;
import com.cenfotec.examen.repository.BodegaRepository;


@Service
public class BodegaServiceImpl implements BodegaService {
@Autowired
BodegaRepository bodegaRepo;
@Override
public void saveBodega(Bodega newBodega) {



	bodegaRepo.save(newBodega);


	
}
@Override
public List<Bodega> getAllBodegas() {
return bodegaRepo.findAll();
}
@Override
public List<Bodega> getById(Iterable<Long> id) {
	// TODO Auto-generated method stub
	return bodegaRepo.findAllById(id);
}
}