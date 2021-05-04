package com.felipe.springboot.app.productos.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipe.springboot.app.productos.models.dao.ProductoDao;
import com.felipe.springboot.app.productos.models.entity.Producto;
import com.felipe.springboot.app.productos.models.service.IproductoService;

@Service
public class ProductoServiceImpl implements IproductoService{

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(new Producto());
	}

}
