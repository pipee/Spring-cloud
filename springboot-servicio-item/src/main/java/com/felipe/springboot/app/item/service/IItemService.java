package com.felipe.springboot.app.item.service;

import java.util.List;

import com.felipe.springboot.app.item.models.Item;

public interface IItemService {
	
	public List<Item> findAll();
	public Item findById(Long id,Integer cantidad);

}
