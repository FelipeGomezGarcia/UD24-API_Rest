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
	ITrabajadorDAO iTrabajadorDAO;
	
	@Override
	public List<Trabajador> listarTrabajadores() {
		
		return iTrabajadorDAO.findAll();
	}

	@Override
	public Trabajador guardarTrabajador(Trabajador trabajador) {
		Long milisecond = System.currentTimeMillis();
		Date fecha = new Date(milisecond);
		trabajador.setFecha(fecha);
		trabajador.asignarSalario();
		return iTrabajadorDAO.save(trabajador);
	}

	@Override
	public Trabajador trabajadorXID(Long id) {
		
		return iTrabajadorDAO.findById(id).get();
	}

	@Override
	public void eliminarTrabajador(Long id) {
		
		iTrabajadorDAO.deleteById(id);
	}

	@Override
	public List<Trabajador> listarTrabajadorEmpleo(String empleo) {
		
		return iTrabajadorDAO.findByEmpleo(empleo);
	}

}
