package com.cenfotec.proyectoApi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.cenfotec.proyectoApi.domain.*;

import com.cenfotec.proyectoApi.service.*;

@RestController
@CrossOrigin(origins = "*")
public class ApiController {
	DynamoDBMapper dynamoDBMapper;

	@Autowired
	AmazonDynamoDB amazonDynamoDB;
	@Autowired
	private CasoService casoService;
	@Autowired
	private reporteService reporteService;


	@PostMapping("/producto")
	public ResponseEntity<String> addColleague(@RequestBody Caso producto) {
//		productoService.saveProducto(producto);
//		return new ResponseEntity<>(HttpStatus.CREATED);
		return null;
	}

	@CrossOrigin(origins = "http://localhost:5000")
	@GetMapping("/reporteCriticos")
	public List<Caso> getCasosCriticos() {
		return reporteService.reporteCriticos();

	}
	
	@CrossOrigin(origins = "http://localhost:5000")
	@GetMapping("/reporteCerrados")
	public List<Caso> getCasosCerrados() {
		return reporteService.reporteCerrados();

	}


	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/productoPorBodego/{id}")
	public List<Caso> getProductos(@PathVariable(value = "id") long id) {
//		return productoService.getProductosByBodegaId(id);
		return null;

	}

}
