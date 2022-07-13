package com.ista.springboot.web.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ista.springboot.web.app.models.entity.Producto;


public interface IProductoDao extends CrudRepository<Producto,Long>{
	

}
