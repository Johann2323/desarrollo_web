package com.ista.springboot.web.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.springboot.web.app.models.dao.IVendedorDao;

import com.ista.springboot.web.app.models.entity.Vendedor;
@Service
public class VendedorServiceImpl implements IVendedorService{

	@Autowired
	private IVendedorDao VendedorDao;
	
	@Override
	@Transactional (readOnly = true)
	public List<Vendedor> findAll() {

		return (List<Vendedor>) VendedorDao.findAll();
	}
	
	@Override
	@Transactional (readOnly = true)
	public Vendedor findById(Long id) {
		return VendedorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Vendedor save(Vendedor vendedor) {
		return VendedorDao.save(vendedor);
	}

	@Override
	@Transactional
	public void delete(Long Id) {
		VendedorDao.deleteById(Id);;
		
	}

}
