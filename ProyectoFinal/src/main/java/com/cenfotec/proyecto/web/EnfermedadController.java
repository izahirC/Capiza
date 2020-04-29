package com.cenfotec.proyecto.web;

import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.cenfotec.proyecto.domain.Paciente;
import com.cenfotec.proyecto.repository.PacienteRepository;
import com.cenfotec.proyecto.service.PacienteServiceImpl;
import com.google.gson.Gson;

@Controller
public class EnfermedadController {
	DynamoDBMapper dynamoDBMapper;

	@Autowired
	AmazonDynamoDB amazonDynamoDB;

	
	@Autowired
	PacienteServiceImpl pacienteService;

	@RequestMapping("/")
	public String index(Model model) throws ParseException {

		Paciente pacienteNuevo = new Paciente();
		
		//ConectarTabla(pacienteNuevo);
		
		
		pacienteNuevo.setNombre("Arturo");
		pacienteNuevo.setApellido("Aymerich");
		pacienteNuevo.setEstadoCivil("Soltero");
		pacienteNuevo.setGenero(Paciente.Genero.MASCULINO);
		pacienteNuevo.setDireccion("Escazu Sanjose");
		pacienteNuevo.setFechaNacimiento(new Date());
		pacienteNuevo.setOcupacion("Ïngeniero");
		pacienteNuevo.setTelefono("87191177");
		pacienteNuevo.setTipoSangre(Paciente.TipoSangre.Op);
		

		pacienteNuevo = pacienteService.savePaciente(pacienteNuevo);

	

		String awsServiceId = pacienteNuevo.getId();



		Optional<Paciente> awsServiceQueried = pacienteService.getById(awsServiceId);

		if (awsServiceQueried.get() != null) {
			System.out.print("Queried object: " + new Gson().toJson(awsServiceQueried.get()));
		}

		Iterable<Paciente> awsServices = pacienteService.getAllPacientes();

		for (Paciente awsServiceObject : awsServices) {
			System.out.print("List object: " + new Gson().toJson(awsServiceObject));
		}
		return "index";
	}


	
	public void ConectarTabla(Object entidad) {


		dynamoDBMapper=new DynamoDBMapper(amazonDynamoDB);
		
		CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(entidad.getClass());
	
		tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L,1L));
	
		TableUtils.createTableIfNotExists(amazonDynamoDB,tableRequest);
	}

}