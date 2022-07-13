package com.ista.springboot.web.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.springboot.web.app.models.dao.IEmpleadoDao;

import com.ista.springboot.web.app.models.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	private IEmpleadoDao EmpleadoDao;
	
	@Override
	@Transactional (readOnly = true)
	public List<Empleado> findAll() {

		return (List<Empleado>) EmpleadoDao.findAll();
	}
	
	@Override
	@Transactional (readOnly = true)
	public Empleado findById(Long id) {
		return EmpleadoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Empleado save(Empleado empleado) {
		return EmpleadoDao.save(empleado);
	}

	@Override
	@Transactional
	public void delete(Long Id) {
		EmpleadoDao.deleteById(Id);;
		
	}

}
