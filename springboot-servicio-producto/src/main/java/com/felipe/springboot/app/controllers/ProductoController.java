package com.felipe.springboot.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.springboot.app.productos.models.entity.Producto;
import com.felipe.springboot.app.productos.models.service.IproductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private IproductoService service;

	@GetMapping("/listar")
	public List<Producto> listar(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Producto detalle(@PathVariable Long id) {
		return service.findById(id);
	}
}
