package com.crud.h2.dto;

import java.util.Date;
import java.util.Iterator;

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
	 * @param empleo
	 * @param salario
	 */
	public Trabajador(Long id, String nombre, String empleo, int salario) {
		this.id = id;
		this.nombre = nombre;
		this.empleo = empleo;
		this.salario = salario;
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
	 * @return the empleo
	 */
	public String getEmpleo() {
		return empleo;
	}

	/**
	 * @param empleo the empleo to set
	 */
	public void setEmpleo(String empleo) {
		this.empleo = empleo;
	}

	/**
	 * @return the salario
	 */
	public int getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(int salario) {
		this.salario = salario;
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
		boolean encontrado = false;
		
		Empleos[] empleos = Empleos.values();
		int count = 0;
		while(count<empleos.length && !encontrado) {
			
			if (empleos[count].name().equals(this.empleo.toLowerCase())) {
				setEmpleo(empleo.toLowerCase());
				switch (empleos[count]) {
				case programador:
					setSalario(2400);
					break;
				case electricista:
					setSalario(1900);
					break;
				case fontanero:
					setSalario(1800);
					break;
				case paleta:
					setSalario(1600);
					break;
				default:
					break;
				}
				encontrado = true;
			}
			count++;
		}
		
		if (!encontrado) {
			setEmpleo("Desempleado");
			setSalario(0);
		}
		
	}
	
	
	
}
