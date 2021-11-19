package org.dao.producto;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.modelo.producto.Producto;

@SuppressWarnings("serial")
public class DaoProducto implements Serializable{
	
	public void addProducto(Producto producto) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(producto);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
	}
	
	public void updateProducto(Producto producto) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.update(producto);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
	}
	
	public void deleteProducto(Producto producto) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.delete(producto);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
	}
	
	public Producto getProductoById(int id) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		Producto producto = null;
		try {
			session.beginTransaction();
			producto = (Producto) session.get(Producto.class,id);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}
		return producto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> listProductos(){
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<Producto> list = null;
		try {
			session.beginTransaction();
			list = (List<Producto>) session.createQuery("from Producto").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}
		return list;
	}
	
}




