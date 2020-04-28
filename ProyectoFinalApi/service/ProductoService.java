package com.cenfotec.examen.service;

import java.util.List;
import java.util.Optional;

import com.cenfotec.examen.domain.Producto;

public interface ProductoService {

	public void saveProducto(Producto newProducto);
	public List<Producto> getAllProductos();
	public Object getById(long id);
	
	
}