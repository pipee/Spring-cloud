package com.felipe.springboot.app.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
	private Environment env;
	
	@Autowired
	private IproductoService service;

	@GetMapping("/listar")
	public List<Producto> listar(){
		return service.findAll().stream().map(producto -> {
			producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return producto;
		} ).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto = service.findById(id);
		producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return producto;
	}
}
