package com.ista.springboot.web.app.models.services;

import java.util.List;

import com.ista.springboot.web.app.models.entity.Vendedor;

public interface IVendedorService {
	public List<Vendedor> findAll();
	public Vendedor save(Vendedor vendedor);
	public Vendedor findById(Long Id);
	public void delete(Long Id);
}
