/**
 * 
 */
package com.jrsaavedra.ereservation.business.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jrsaavedra.ereservation.model.Reservation;

/**
 * Definir operaciones básicas para el modelo de reserva
 * @author Jrsaavedra
 *
 */
public interface ReservationRepository extends JpaRepository<Reservation, String> {
	
	@Query("Select r from Reservation r where r.reservationStartDate =:initDate and reservationEndDate =:endDate")
	public List<Reservation> find(@Param("initDate") Date initDate, @Param("endDate") Date endDate);
	
	Reservation findByNumberReservation(String numberReservation);
}
