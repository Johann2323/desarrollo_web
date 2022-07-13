package com.ista.springboot.web.app.models.services;

import java.util.List;

import com.ista.springboot.web.app.models.entity.Cliente;

public interface IClienteService {
	public List<Cliente> findAll();
	public Cliente save(Cliente cliente);
	public Cliente findById(Long Id);
	public void delete(Long Id);
}
