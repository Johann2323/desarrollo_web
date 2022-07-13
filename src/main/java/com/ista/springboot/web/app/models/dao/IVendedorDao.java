package com.ista.springboot.web.app.models.dao;

import org.springframework.data.repository.CrudRepository;


import com.ista.springboot.web.app.models.entity.Vendedor;

public interface IVendedorDao extends CrudRepository<Vendedor,Long>{

}
