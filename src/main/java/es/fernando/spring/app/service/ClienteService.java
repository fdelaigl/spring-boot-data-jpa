package es.fernando.spring.app.service;

import java.util.List;

import es.fernando.spring.app.entity.Cliente;

/**
 * The Interface ClienteService.
 */
public interface ClienteService {
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Cliente> findAll();
	
	/**
	 * Save.
	 *
	 * @param cliente the cliente
	 */
	public void save(Cliente cliente);
	
	/**
	 * Find one.
	 *
	 * @param id the id
	 * @return the cliente
	 */
	public Cliente findOne(Long id);
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public void delete(Long id);
}
