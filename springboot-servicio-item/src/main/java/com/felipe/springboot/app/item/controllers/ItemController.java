package com.felipe.springboot.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.springboot.app.item.models.Item;
import com.felipe.springboot.app.item.service.IItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private IItemService service;
	
	@GetMapping("/listar")
	public List<Item> listar(){
		return service.findAll();
	}
	
	@GetMapping("/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad){
		return service.findById(id, cantidad);
	}
}
