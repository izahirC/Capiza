package com.cenfotec.proyecto.service;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.proyecto.domain.Caso;
import com.cenfotec.proyecto.repository.CasoRepository;

@Service
public class CasoServiceImpl implements CasoService {
	@Autowired
	CasoRepository casoRepo;

	@Override
	public Caso saveCaso(Caso newCaso) {
		Date date = new Date();
		newCaso.setFecha(date);
		return casoRepo.save(newCaso);
		
	}

	@Override
	public List<Caso> getAllCasos() {
		List<Caso> listaCasos=(List<Caso>) casoRepo.findAll();
		return listaCasos;
	}

	@Override
	public Optional<Caso> getById(String id) {
		Optional<Caso> caso = casoRepo.findById(id);
		return caso;
	}

	@Override
	public void deleteById(String id){
		casoRepo.deleteById(id);
			
	}
	

}