package com.felipe.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.felipe.springboot.app.item.models.Producto;

@FeignClient(name = "servicio-productos", url = "localhost:8001")
public interface IProductoClienteRest {

	@GetMapping("/producto/listar")
	public List<Producto> listar();
	
	@GetMapping("/producto/{id}")
	public Producto detalle(@PathVariable Long id);
}
