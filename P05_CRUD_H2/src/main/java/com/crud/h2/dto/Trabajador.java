package com.crud.h2.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="trabajador")//en caso que la tabala sea diferente
public class Trabajador {

	//Atributos de entidad cliente
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id;
	@Column(name = "nombre")//no hace falta si se llama igual
	private String nombre;
	@Column(name = "empleo")//no hace falta si se llama igual
	private String empleo;
	@Column(name = "salario")//no hace falta si se llama igual
	private int salario;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	//Constructores
	
	public Trabajador() {
	
	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param direccion
	 * @param dni
	 * @param fecha
	 */
	public Trabajador(Long id, String nombre, String apellido, int dni) {
		//super();
		this.id = id;
		this.nombre = nombre;
		this.empleo = apellido;
		this.salario = dni;
		asignarSalario();
	}

	
	//Getters y Setters
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getEmpleo() {
		return empleo;
	}

	/**
	 * @param empleo the apellido to set
	 */
	public void setEmpleo(String empleo) {
		this.empleo = empleo;
	}

	/**
	 * @return the dni
	 */
	public int getSalario() {
		return salario;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setSalario(int dni) {
		this.salario = dni;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	//Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", empleo=" + empleo
				+ ", salario=" + salario + ", fecha=" + fecha + "]";
	}
	
	public void asignarSalario() {
		
		String programador = Empleos.programador.toString();
		String electricista = Empleos.electricista.toString();
		String fontanero = Empleos.fontanero.toString();
		String paleta = Empleos.paleta.toString();
		
		if (this.empleo.equals(programador)) {
			setSalario(2400);
		}else if (this.empleo.equals(electricista)) {
			setSalario(1900);
		}else if (this.empleo.equals(fontanero)) {
			setSalario(1800);
		}else if (this.empleo.equals(paleta)) {
			setSalario(1600);
		}
		
	}
	
	
	
}
