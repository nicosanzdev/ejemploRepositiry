package org.controller.producto;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.dao.producto.DaoProducto;
import org.modelo.producto.Producto;

@ManagedBean
@ViewScoped
public class ControllerProducto implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	private List<Producto> listaProductos;
	private Producto producto;
	
	public ControllerProducto() {
		producto = new Producto();
	}

	public List<Producto> getListaProductos() {
		DaoProducto dao = new DaoProducto();
		listaProductos = dao.listProductos();
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	//GETTERS AND SETTERS DE PRODUCTO
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	//METODOS DAO PERSONA
	public void limpiarProducto() {
		producto = new Producto();
	}
	public String agregarProducto() {
		DaoProducto dao = new DaoProducto();
		dao.addProducto(producto);
		return "/index.xhtml?faces-redirect=true";
	}
	
	public String ModificarProductos() {
		DaoProducto dao = new DaoProducto();
		dao.updateProducto(producto);
		return "/index.xhtml?faces-redirect=true";
	}
	
	public String eliminarProducto() {
		DaoProducto dao = new DaoProducto();
		dao.deleteProducto(producto);
		return "/index.xhtml?faces-redirect=true";
	}
}
