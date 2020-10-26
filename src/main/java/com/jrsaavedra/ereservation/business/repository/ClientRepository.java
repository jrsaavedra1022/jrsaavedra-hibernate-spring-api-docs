/**
 * 
 */
package com.jrsaavedra.ereservation.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrsaavedra.ereservation.model.Client;

/**
 * Interface para definir las operaciones de bd reliacionadas con el cliente
 * @author Jrsaavedra
 *
 */
public interface ClientRepository extends JpaRepository<Client, String>{
	
	/**
	 * Definición de metodo para buscar los cliente por su apellido
	 * @param lastName
	 * @return
	 */
	public List<Client> findByLastName(String lastName);
	
	public Client findByIdentification(String document);

	
}
