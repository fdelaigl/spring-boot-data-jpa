package es.fernando.spring.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import es.fernando.spring.app.dao.ClienteDao;
import es.fernando.spring.app.entity.Cliente;

@Component
public class ClienteDaoImpl implements ClienteDao {
	@PersistenceContext
	private EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() {
		return em.createQuery("from Cliente").getResultList();
	}


	@Override
	@Transactional
	public void save(Cliente cliente) {
		if(cliente.getId() != null && cliente.getId() > 0) {
			em.merge(cliente);
		}else {
		em.persist(cliente);
		}
		
	}


	@Override
	public Cliente findOne(Long id) {
		return em.find(Cliente.class, id);
	}

}
