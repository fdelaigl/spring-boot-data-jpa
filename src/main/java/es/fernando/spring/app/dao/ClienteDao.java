package es.fernando.spring.app.dao;

import org.springframework.data.repository.CrudRepository;

import es.fernando.spring.app.entity.Cliente;

/**
 * The Interface ClienteDao.
 */
public interface ClienteDao extends CrudRepository<Cliente, Long>{
	//Repository CRUD
}
