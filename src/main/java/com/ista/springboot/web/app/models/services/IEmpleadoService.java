package com.ista.springboot.web.app.models.services;

import java.util.List;


import com.ista.springboot.web.app.models.entity.Empleado;

public interface IEmpleadoService {
	public List<Empleado> findAll();
	public Empleado save(Empleado empleado);
	public Empleado findById(Long Id);
	public void delete(Long Id);
}
