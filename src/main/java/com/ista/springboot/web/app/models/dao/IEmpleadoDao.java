package com.ista.springboot.web.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ista.springboot.web.app.models.entity.Empleado;

public interface IEmpleadoDao extends CrudRepository<Empleado,Long> {

}
