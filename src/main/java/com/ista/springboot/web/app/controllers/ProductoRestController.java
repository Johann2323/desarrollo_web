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

import com.ista.springboot.web.app.models.entity.Producto;

import com.ista.springboot.web.app.models.services.IProductoService;


@CrossOrigin(origins = { "http:localhost:4200" })
@RestController
@RequestMapping("/api")
public class ProductoRestController {
	@Autowired
	private IProductoService productoService;

	@GetMapping("/producto")

	public List<Producto> index() {
		return productoService.findAll();
	}

//Bucar 
	@GetMapping("/producto/{id}")
	public Producto show(@PathVariable Long id) {
		return productoService.findById(id);
	}

//guardar 

	@PostMapping("/producto")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto add(@RequestBody Producto producto) {

		return productoService.save(producto);
	}

//eliminar
	@DeleteMapping("/producto/{id}")
	public void deleteById(@PathVariable Long id) {
		productoService.delete(id);
	}

//editar
	@PutMapping("/producto/{id}")
	public Producto update(@RequestBody Producto producto, @PathVariable Long id) {
		Producto productoActual = productoService.findById(id);
		productoActual.setNombre(producto.getNombre());	
		productoActual.setDescripcion(producto.getDescripcion());

		productoActual.setCosto(producto.getCosto());
		productoActual.setStock(producto.getStock());

		return productoService.save(productoActual);

	}
}
