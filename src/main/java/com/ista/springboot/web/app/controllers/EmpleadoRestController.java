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

import com.ista.springboot.web.app.models.entity.Empleado;

import com.ista.springboot.web.app.models.services.IEmpleadoService;

@CrossOrigin(origins = { "http:localhost:4200" })
@RestController
@RequestMapping("/api")
public class EmpleadoRestController {
	@Autowired
	private IEmpleadoService empleadoService;

	@GetMapping("/empleado")

	public List<Empleado> index() {
		return empleadoService.findAll();
	}

//Bucar 
	@GetMapping("/empleado/{id}")
	public Empleado show(@PathVariable Long id) {
		return empleadoService.findById(id);
	}

//guardar 

	@PostMapping("/empleado")
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado add(@RequestBody Empleado empleado) {

		return empleadoService.save(empleado);
	}

//eliminar
	@DeleteMapping("/empleado/{id}")
	public void deleteById(@PathVariable Long id) {
		empleadoService.delete(id);
	}

//editar
	@PutMapping("/empleado/{id}")
	public Empleado update(@RequestBody Empleado empleado, @PathVariable Long id) {
		Empleado empleadoActual = empleadoService.findById(id);
		empleadoActual.setNombre(empleado.getNombre());
		empleadoActual.setApellido(empleado.getApellido());

		empleadoActual.setCedula(empleado.getCedula());
		empleadoActual.setFecha_n(empleado.getFecha_n());
		empleadoActual.setDireccion(empleado.getDireccion());
		empleadoActual.setSexo(empleado.getSexo());
		empleadoActual.setSalario(empleado.getSalario());
		empleadoActual.setSuperci(empleado.getSuperci());
		empleadoActual.setDno(empleado.getDno());

		return empleadoService.save(empleadoActual);

	}

}
