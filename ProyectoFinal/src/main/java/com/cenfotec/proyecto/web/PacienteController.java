package com.cenfotec.proyecto.web;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.cenfotec.proyecto.domain.Caso;
import com.cenfotec.proyecto.domain.Clinica;
import com.cenfotec.proyecto.domain.Enfermedad;
import com.cenfotec.proyecto.domain.Paciente;
import com.cenfotec.proyecto.repository.CasoRepository;
import com.cenfotec.proyecto.repository.ClinicaRepository;
import com.cenfotec.proyecto.repository.EnfermedadRepository;
import com.cenfotec.proyecto.repository.PacienteRepository;
import com.cenfotec.proyecto.service.CasoServiceImpl;
import com.cenfotec.proyecto.service.ClinicaServiceImpl;
import com.cenfotec.proyecto.service.EnfermedadServiceImpl;
import com.cenfotec.proyecto.service.PacienteServiceImpl;
import com.google.gson.Gson;

@Controller
public class PacienteController {
	DynamoDBMapper dynamoDBMapper;

	@Autowired
	AmazonDynamoDB amazonDynamoDB;

//	@Autowired
//	PacienteRepository pacienteRepository;
//	@Autowired
//	CasoRepository casoRepository;
//	@Autowired
//	ClinicaRepository clinicaRepository;
//	@Autowired
//	EnfermedadRepository enfermedadRepository;
//	
	@Autowired
	CasoServiceImpl casoService;
	@Autowired
	PacienteServiceImpl pacienteService;
	@Autowired
	EnfermedadServiceImpl enfermedadService;
	@Autowired
	ClinicaServiceImpl clinicaService;

	@RequestMapping("/")
	public String index(Model model) throws ParseException {

		Caso casoNuevo = new Caso();

		// ConectarTabla(casoNuevo);

		Optional<Paciente> p=pacienteService.getById("12045fef-b3a0-4248-af6f-eeb46983c688");
		casoNuevo.setClinica("Clinica");
		casoNuevo.setEnfermedad("enfermedad");
		casoNuevo.setSintomas("Sintomas");
		//casoNuevo.setPaciente(p.get());

		
		casoNuevo= casoService.saveCaso(casoNuevo);
		// pacienteNuevo = pacienteService.savePaciente(pacienteNuevo);

//
//		String awsServiceId = pacienteNuevo.getId();
//
//
//
//		Optional<Paciente> awsServiceQueried = pacienteService.getById(awsServiceId);
//
//		if (awsServiceQueried.get() != null) {
//			System.out.print("Queried object: " + new Gson().toJson(awsServiceQueried.get()));
//		}
//
//		Iterable<Paciente> awsServices = pacienteRepository.findAll();
//
//		for (Paciente awsServiceObject : awsServices) {
//			System.out.print("List object: " + new Gson().toJson(awsServiceObject));
//		}
		return "index";
	}

	@RequestMapping("/nuevoCaso")
	public String nuevoCaso(Model model) throws ParseException {

		Caso nCaso = new Caso();
		model.addAttribute("caso", nCaso);
		// para realizar el Dropdown

		List<Enfermedad> listaEnfermedades = enfermedadService.getAllEnfermedades();
		model.addAttribute("enfermedades", listaEnfermedades);

		List<Clinica> listaClinicas = clinicaService.getAllClinicas();
		model.addAttribute("clinicas", listaClinicas);

		return "nuevoCaso";
	}

	@PostMapping("/addCaso")
	public String submit(Model model, @ModelAttribute Caso caso, BindingResult result) {
		if (!result.hasErrors()) {
			casoService.saveCaso(caso);
			Caso nCaso = new Caso();
			model.addAttribute("caso", nCaso);
			// para realizar el Dropdown

			List<Enfermedad> listaEnfermedades = enfermedadService.getAllEnfermedades();
			model.addAttribute("enfermedades", listaEnfermedades);

			List<Clinica> listaClinicas = clinicaService.getAllClinicas();
			model.addAttribute("clinicas", listaClinicas);
			model.addAttribute("nuevo", caso.getId());
			return "nuevoProducto";
		} else {

			Caso nCaso = new Caso();
			model.addAttribute("caso", nCaso);
			// para realizar el Dropdown

			List<Enfermedad> listaEnfermedades = enfermedadService.getAllEnfermedades();
			model.addAttribute("enfermedades", listaEnfermedades);

			List<Clinica> listaClinicas = clinicaService.getAllClinicas();
			model.addAttribute("clinicas", listaClinicas);
			model.addAttribute("error", "Error");
			return "nuevoProducto";
		}

	}

	public void ConectarTabla(Object entidad) {

		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

		CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(entidad.getClass());

		tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

		TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);
	}

}
