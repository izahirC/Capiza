package com.cenfotec.examen.service;

import java.util.List;

import com.cenfotec.examen.domain.Bodega;

public interface BodegaService {

	public void saveBodega(Bodega newBodega);
	public List<Bodega> getAllBodegas();
	public List<Bodega> getById(Iterable<Long> id);
	
	
}