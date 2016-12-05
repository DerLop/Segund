package py.edu.facitec.examen_parcial_ii.dao;

import java.util.List;

import javax.persistence.Query;

import py.edu.facitec.examen_parcial_ii.modelo.Cliente;

public class ClienteDao extends GenericDao<Cliente> {

	public ClienteDao() {
		super(Cliente.class);
	}
	
	public List<Cliente> recuperarPorFiltro(String filtro) {
		int filtroId = 0;
		try {
			filtroId = Integer.parseInt(filtro);
		} catch (NumberFormatException e) {
		}
		
		instanciarCrieteria();
		criteriaQuery.where(
				builder.or(
						builder.like(
								builder.lower(
										root.<String>get("nombre")
										), 
								"%"+filtro.toLowerCase()+"%"),
										
						builder.equal(root.<Integer>get("id"), filtroId)
						),
				builder.isTrue(root.<Boolean>get("estado"))
				);
		lista = session.createQuery(criteriaQuery).getResultList();
		cerrar();
		return lista;
	}
	
}
