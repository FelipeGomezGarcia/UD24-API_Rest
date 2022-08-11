package com.crud.h2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.h2.dto.Trabajador;

/**
 * @author Jose
 *
 */
public interface ITrabajadorDAO extends JpaRepository<Trabajador, Long>{
	
	//Listar clientes or campo nombre
	public List<Trabajador> findByNombre(String nombre);
	
}
