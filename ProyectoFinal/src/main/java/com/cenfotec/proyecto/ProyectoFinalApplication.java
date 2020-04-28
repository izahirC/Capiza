package com.cenfotec.proyecto;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.cenfotec.proyecto.repository.PacienteRepository;



@SpringBootApplication
public class ProyectoFinalApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ProyectoFinalApplication.class, args);
	}

}
