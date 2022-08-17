package com.crud.h2.service;

import java.util.List;

/**
 * @author Jose
 *
 */
import com.crud.h2.dto.Trabajador;

public interface ITrabajadorService {

	//Metodos del CRUD
	public List<Trabajador> listarTrabajadores(); //Listar All 
	
	public Trabajador guardarTrabajador(Trabajador trabajador);	//Guarda un Trabajador CREATE
	
	public Trabajador trabajadorXID(Long id); //Leer datos de un Trabajadores READ
	
	public List<Trabajador> listarTrabajadorEmpleo(String empleo);//Listar Trabajadores por campo empleo
	
	public void eliminarTrabajador(Long id);// Elimina el Trabajador DELETE
	
	
}
