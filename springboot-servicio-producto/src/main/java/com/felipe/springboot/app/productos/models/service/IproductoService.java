package com.felipe.springboot.app.productos.models.service;

import java.util.List;

import com.felipe.springboot.app.productos.models.entity.Producto;

public interface IproductoService {
	
	public List<Producto> findAll();
	public Producto findById(Long id);

}
