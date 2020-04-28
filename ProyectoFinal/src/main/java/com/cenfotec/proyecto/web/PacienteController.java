package com.cenfotec.proyecto.web;

import java.text.ParseException;
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
import com.google.gson.Gson;

@Controller
public class PacienteController {
	DynamoDBMapper dynamoDBMapper;

	@Autowired
	AmazonDynamoDB amazonDynamoDB;

	@Autowired
	PacienteRepository awsServiceRepository;

	@RequestMapping("/")
	public String index(Model model) throws ParseException {
		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

		CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Paciente.class);

		tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

		TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);

		Paciente awsService = new Paciente();

		awsService.setNombre("Arturo");

		awsService = awsServiceRepository.save(awsService);

	

		String awsServiceId = awsService.getId();



		Optional<Paciente> awsServiceQueried = awsServiceRepository.findById(awsServiceId);

		if (awsServiceQueried.get() != null) {
			System.out.print("Queried object: " + new Gson().toJson(awsServiceQueried.get()));
		}

		Iterable<Paciente> awsServices = awsServiceRepository.findAll();

		for (Paciente awsServiceObject : awsServices) {
			System.out.print("List object: " + new Gson().toJson(awsServiceObject));
		}
		return "index";
	}

}
