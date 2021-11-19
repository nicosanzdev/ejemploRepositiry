package org.modelo.producto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Producto implements Serializable{
	private Integer id;
	private String nombre;
	private float precio;

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public Producto(Integer id) {
		super();
		this.id = id;
	}

	public Producto(Integer id, String nombre, float precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	//GETTERS AND SETTERS
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
