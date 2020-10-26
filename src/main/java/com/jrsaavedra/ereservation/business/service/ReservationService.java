package com.jrsaavedra.ereservation.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jrsaavedra.ereservation.business.repository.ReservationRepository;
import com.jrsaavedra.ereservation.model.Reservation;

/**
 * Clase para definir los servicios de una Reservación
 * 
 * @author Jrsaavedra
 *
 */
@Service
@Transactional(readOnly = true)
public class ReservationService {
	private final ReservationRepository reservationRepository;

	// constructor
	public ReservationService(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	/**
	 * Método para realizar la operación de guardar un Reserva
	 * 
	 * @param reservation
	 * @return
	 */
	@Transactional
	public Reservation create(Reservation reservation) {
		return this.reservationRepository.save(reservation);
	}

	/**
	 * Método para realizar la operación de actualizar una Reserva
	 * 
	 * @param reservation
	 * @return
	 */
	@Transactional
	public Reservation update(Reservation reservation) {
		return this.reservationRepository.save(reservation);
	}

	/**
	 * Método para eliminar una reserva
	 * 
	 * @param reservation
	 */
	@Transactional
	public void delete(Reservation reservation) {
		this.reservationRepository.delete(reservation);
	}

	/**
	 * Método para consultar una reserva a partir de su número de reserva
	 * 
	 * @param numberReservation
	 * @return
	 */
	public Reservation findByNumberReservation(String numberReservation) {
		return this.findByNumberReservation(numberReservation);
	}

	/**
	 * Método para consultar las reservas en un rango de fechas
	 * 
	 * @param dateInit
	 * @param dateEnd
	 * @return
	 */
	public List<Reservation> find(Date dateInit, Date dateEnd) {
		return this.find(dateInit, dateEnd);
	}
}
