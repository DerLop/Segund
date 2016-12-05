package py.edu.facitec.examen_parcial_ii.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import py.edu.facitec.examen_parcial_ii.util.Factory;

public class GenericDao <T>{
	protected Session session;
	private Class<T> entity;
	protected CriteriaBuilder builder;
	protected CriteriaQuery<T> criteriaQuery;
	protected Root<T> root;
	protected List<T> lista;
	
	public GenericDao(Class<T> entity) {
		this.entity = entity;
		session = Factory.getSessionFactory().openSession();
	}
	
	public void insertarOModificar(T entity){
		session.beginTransaction();
		session.saveOrUpdate(entity);
	}
	
	public void eliminar(T entity){
		session.beginTransaction();
		session.delete(entity);
	}
	
	public T recuperarPorId(int id){
		T result = session.get(entity, id);
		cerrar();
		return result;
	}
	
	public List<T> recuperarTodo(){
		//consulta utilizando hibernate query lenguage HQL 
		String hql = "FROM "+entity.getName()+" ORDER BY id";
		Query query = session.createQuery(hql);
		lista = query.getResultList();
		cerrar();
		return lista;
	}
	
	public void ejecutar() throws Exception{
		session.flush();
		session.getTransaction().commit();
		cerrar();
	}
	
	public void cancelar(){
		session.getTransaction().rollback();
		session.clear();
		cerrar();
	}
	
	public void cerrar(){
		session.close();
	}
	
	protected void instanciarCrieteria() {
		//Instanciar los objetos necesarios para utilizar criterea
		builder = session.getCriteriaBuilder();
		criteriaQuery = builder.createQuery(entity);
		root = criteriaQuery.from( entity );
		criteriaQuery.select( root );
	}
	
}
