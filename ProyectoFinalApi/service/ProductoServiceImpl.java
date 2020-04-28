package com.cenfotec.examen.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cenfotec.examen.domain.Producto;
import com.cenfotec.examen.repository.ProductoRepository;


@Service
public class ProductoServiceImpl implements ProductoService {
@Autowired
ProductoRepository productoRepo;
@Override
public void saveProducto(Producto newProducto) {

	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");  
	LocalDateTime now = LocalDateTime.now();  
	
	newProducto.setFecha(dtf.format(now) );

	productoRepo.save(newProducto);


	
}
@Override
public List<Producto> getAllProductos() {
return productoRepo.findAll();
}
@Override
public Object getById(long id) {
	// TODO Auto-generated method stub
	return productoRepo.findById(id);
}
}