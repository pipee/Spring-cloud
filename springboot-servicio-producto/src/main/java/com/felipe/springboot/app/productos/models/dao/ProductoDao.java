package com.felipe.springboot.app.productos.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.springboot.app.productos.models.entity.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoDao extends JpaRepository<Producto, Long> {

}
