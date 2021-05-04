package com.felipe.springboot.app.item.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.felipe.springboot.app.item.clientes.IProductoClienteRest;
import com.felipe.springboot.app.item.models.Item;
import com.felipe.springboot.app.item.service.IItemService;

@Service("serviceFeing")
@Primary
public class ItemServiceFeing implements IItemService {

	@Autowired
	private IProductoClienteRest clienteFeign;
	
	@Override
	public List<Item> findAll() {
		return clienteFeign.listar().stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteFeign.detalle(id), cantidad);
	}

}
