package com.jrsaavedra.ereservation.view.resource.vo;

import java.util.Date;

import lombok.Data;

/**
 * Clase que representa a la Tabla reservations virtual
 * 
 * @author Bios-hp
 *
 */
@Data
public class ReservationVO {
	// attributes
	private String numberReservation;
	private Date reservationStartDate;
	private Date reservationEndDate;
	private int amountPeople;
	private String description;
}
