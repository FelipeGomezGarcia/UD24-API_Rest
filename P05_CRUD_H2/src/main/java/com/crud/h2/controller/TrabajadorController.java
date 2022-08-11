package com.crud.h2.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.h2.dto.Trabajador;
import com.crud.h2.service.TrabajadorServiceImpl;

@RestController
@RequestMapping("/api")
public class TrabajadorController {
	
	@Autowired
	TrabajadorServiceImpl clienteServideImpl;
	
	@GetMapping("/trabajadores")
	public List<Trabajador> listarTrabajadores(){
		return clienteServideImpl.listarTrabajadores();
	}
	
	//listar Clientes por campo nombre
	@GetMapping("/trabajadores/nombre/{nombre}")
	public List<Trabajador> listarTrabajadorNombre(@PathVariable(name="nombre") String nombre) {
	    return clienteServideImpl.listarTrabajadorNomnbre(nombre);
	}
	
	
	@PostMapping("/trabajadores")
	public Trabajador salvarTrabajador(@RequestBody Trabajador trabajador) {
		
		return clienteServideImpl.guardarTrabajador(trabajador);
	}
	
	
	@GetMapping("/trabajadores/{id}")
	public Trabajador trabajadorXID(@PathVariable(name="id") Long id) {
		
		Trabajador cliente_xid= new Trabajador();
		
		cliente_xid=clienteServideImpl.trabajadorXID(id);
		
		System.out.println("Trabajador XID: "+cliente_xid);
		
		return cliente_xid;
	}
	
	@PutMapping("/trabajadores/{id}")
	public Trabajador actualizarTrabajador(@PathVariable(name="id")Long id,@RequestBody Trabajador trabajador) {
		
		Trabajador trabajador_seleccionado= new Trabajador();
		Trabajador trabajador_actualizado= new Trabajador();
		
		trabajador_seleccionado= clienteServideImpl.trabajadorXID(id);
		
		if (!(trabajador.getNombre()== null)) {
			trabajador_seleccionado.setNombre(trabajador.getNombre());
		}
		
		
		trabajador_seleccionado.setEmpleo(trabajador.getEmpleo());
		trabajador_seleccionado.setSalario(trabajador.getSalario());
		trabajador_seleccionado.setFecha(trabajador.getFecha());
		
		trabajador_actualizado = clienteServideImpl.guardarTrabajador(trabajador_seleccionado);
		
		System.out.println("El trabajador actualizado es: "+ trabajador_actualizado);
		
		return trabajador_actualizado;
	}
	
	@DeleteMapping("/trabajadores/{id}")
	public void eliminarTrabajador(@PathVariable(name="id")Long id) {
		clienteServideImpl.eliminarTrabajador(id);
	}
	
	
}
