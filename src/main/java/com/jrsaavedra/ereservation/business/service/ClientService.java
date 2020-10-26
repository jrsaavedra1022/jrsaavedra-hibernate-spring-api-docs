/**
 * 
 */
package com.jrsaavedra.ereservation.business.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jrsaavedra.ereservation.business.repository.ClientRepository;
import com.jrsaavedra.ereservation.model.Client;

/**
 * Clase para definir los servicios de cliente
 * 
 * @author Jrsaavedra
 *
 */

@Service
@Transactional(readOnly = true)
public class ClientService {
	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		// TODO Auto-generated constructor stub
		this.clientRepository = clientRepository;
	}

	/**
	 * Método para realizar operación de guardar un cliente
	 * 
	 * @param client
	 * @return
	 */
	@Transactional
	public Client create(Client client) {
		return this.clientRepository.save(client);
	}

	/**
	 * Método para realizar la operación de actualizar un cliente
	 * 
	 * @param client
	 * @return
	 */
	@Transactional
	public Client update(Client client) {
		return this.clientRepository.save(client);
	}

	/**
	 * Método para realizar la operación de eliminar un cliente
	 * 
	 * @param client
	 */
	@Transactional
	public void delete(Client client) {
		this.clientRepository.delete(client);
	}

	/**
	 * Método para consultar un cliente a partir de su Apellido
	 * 
	 * @param lastName
	 * @return
	 */
	public List<Client> findByLastName(String lastName) {
		return this.clientRepository.findByLastName(lastName);
	}

	/**
	 * Método para consultar un cliente a partir de su número de identificación
	 * 
	 * @param document
	 * @return
	 */
	public Client findByDocument(String document) {
		return this.clientRepository.findByDocument(document);
	}

	/**
	 * Método para consultar todos los cliente existentes
	 * 
	 * @return
	 */
	public List<Client> findAll() {
		return this.clientRepository.findAll();
	}

}
