/**
 * 
 */
package com.jrsaavedra.ereservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla Reservation
 * @author Jrsaavedra
 *
 */
@Data
@Entity
@Table(name="reservations")
public class Reservation {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String id;
	private String numberReservation;
	@Temporal(TemporalType.DATE)
	private Date reservationStartDate;
	@Temporal(TemporalType.DATE)
	private Date reservationEndDate;
	private int amountPeople;
	private String description;
	//Fk
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	

}
