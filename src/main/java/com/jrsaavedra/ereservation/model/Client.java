/**
 * 
 */
package com.jrsaavedra.ereservation.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa a la tabla Client
 * @author Jrsaavedra
 *
 */

@Data //no es necesario generar getters and setters
@Entity
@Table(name="clients")
@NamedQuery(name="Client.findByIdentification", query="Select c from Client c where c.document = ?1")
public class Client {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String id;
	private String name;
	private String lastName;
	private String document;
	private String address;
	private String phone;
	private String email;
	//fk many reservas
	@OneToMany(mappedBy="client")
	private Set<Reservation> reservations;
	//constructor
	public Client() {
		
	}
	
	
	
}
