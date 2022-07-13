package com.ista.springboot.web.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.springboot.web.app.models.dao.IClienteDao;
import com.ista.springboot.web.app.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{
	@Autowired
	private IClienteDao ClienteDao;
	
	@Override
	@Transactional (readOnly = true)
	public List<Cliente> findAll() {

		return (List<Cliente>) ClienteDao.findAll();
	}
	
	@Override
	@Transactional (readOnly = true)
	public Cliente findById(Long id) {
		return ClienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return ClienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long Id) {
		ClienteDao.deleteById(Id);;
		
	}
	
	

	

}
