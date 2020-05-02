package com.cenfotec.proyectoApi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.proyectoApi.domain.Caso;
import com.cenfotec.proyectoApi.repository.CasoRepository;

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
		List<Caso> lista = (List<Caso>) casoRepo.findAll();
		List<Caso> Criticos=new ArrayList<>();
		for (Caso caso : lista) {
			if (caso.getEstado() == Caso.Estado.CRITICO) {
				Criticos.add(caso);
			}
		}
		return Criticos;
	}

}
