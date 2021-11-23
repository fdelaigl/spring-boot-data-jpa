package es.fernando.spring.app.dao;

import java.util.List;

import es.fernando.spring.app.entity.Cliente;

public interface ClienteDao {
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
}
