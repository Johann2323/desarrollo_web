package com.ista.springboot.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.springboot.web.app.models.entity.Vendedor;

import com.ista.springboot.web.app.models.services.IVendedorService;

@CrossOrigin(origins = { "http:localhost:4200" })
@RestController
@RequestMapping("/api")
public class VendedorRestController {
	@Autowired
	private IVendedorService vendedorService;

	@GetMapping("/vendedor")

	public List<Vendedor> index() {
		return vendedorService.findAll();
	}

//Bucar 
	@GetMapping("/vendedor/{id}")
	public Vendedor show(@PathVariable Long id) {
		return vendedorService.findById(id);
	}

//guardar 

	@PostMapping("/vendedor")
	@ResponseStatus(HttpStatus.CREATED)
	public Vendedor add(@RequestBody Vendedor vendedor) {

		return vendedorService.save(vendedor);
	}

//eliminar
	@DeleteMapping("/vendedor/{id}")
	public void deleteById(@PathVariable Long id) {
		vendedorService.delete(id);
	}

//editar
	@PutMapping("/vendedor/{id}")
	public Vendedor update(@RequestBody Vendedor vendedor, @PathVariable Long id) {
		Vendedor vendedorActual = vendedorService.findById(id);
		vendedorActual.setNombre(vendedor.getNombre());	
		vendedorActual.setApellido(vendedor.getApellido());

		vendedorActual.setDireccion(vendedor.getDireccion());
		vendedorActual.setTelefono(vendedor.getTelefono());
		vendedorActual.setEmail(vendedor.getEmail());
		return vendedorService.save(vendedorActual);

	}
}
