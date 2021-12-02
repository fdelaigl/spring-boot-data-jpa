package es.fernando.spring.app.dao;

import org.springframework.data.repository.CrudRepository;

import es.fernando.spring.app.entity.Factura;

public interface FacturaDao extends CrudRepository<Factura, Long> {
	

}
