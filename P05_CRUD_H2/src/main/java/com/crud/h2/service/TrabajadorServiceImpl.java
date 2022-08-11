package com.crud.h2.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.h2.dao.ITrabajadorDAO;
import com.crud.h2.dto.Trabajador;

@Service
public class TrabajadorServiceImpl implements ITrabajadorService{
	
	//Utilizamos los metodos de la interface IClienteDAO, es como si instaciaramos.
	@Autowired
	ITrabajadorDAO iClienteDAO;
	
	@Override
	public List<Trabajador> listarTrabajadores() {
		
		return iClienteDAO.findAll();
	}

	@Override
	public Trabajador guardarTrabajador(Trabajador trabajador) {
		Long milisecond = System.currentTimeMillis();
		Date fecha = new Date(milisecond);
		trabajador.setFecha(fecha);
		trabajador.asignarSalario();
		return iClienteDAO.save(trabajador);
	}

	@Override
	public Trabajador trabajadorXID(Long id) {
		
		return iClienteDAO.findById(id).get();
	}

	@Override
	public void eliminarTrabajador(Long id) {
		
		iClienteDAO.deleteById(id);
		
	}


	@Override
	public List<Trabajador> listarTrabajadorNomnbre(String nombre) {
		
		return iClienteDAO.findByNombre(nombre);
	}

}
