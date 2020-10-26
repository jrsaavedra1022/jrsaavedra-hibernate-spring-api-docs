package com.jrsaavedra.ereservation.view.resource;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrsaavedra.ereservation.business.service.ReservationService;
import com.jrsaavedra.ereservation.model.Reservation;
import com.jrsaavedra.ereservation.view.resource.vo.ReservationVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/reservas")
@Api(tags = "reserva")
public class ReservationResource {
	private final ReservationService reservationService;

	public ReservationResource(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@PostMapping
	@ApiOperation(value = "Crear reserva", notes = "Servicio para crear una reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reserva creada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud inválida") })
	public ResponseEntity<Reservation> createReservation(@RequestBody ReservationVO reservationVo) {
		Reservation reservation = new Reservation();
		reservation.setNumberReservation(reservationVo.getNumberReservation());
		reservation.setReservationStartDate(reservationVo.getReservationStartDate());
		reservation.setReservationEndDate(reservationVo.getReservationEndDate());
		reservation.setAmountPeople(reservationVo.getAmountPeople());

		return new ResponseEntity<Reservation>(this.reservationService.create(reservation), HttpStatus.CREATED);
	}

	@PutMapping("/{numberReservation}")
	@ApiOperation(value = "Actualizar reserva", notes = "Servicio para actualizar una reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reserva actualizada correctamente"),
			@ApiResponse(code = 404, message = "Reserva no encontrado") })
	public ResponseEntity<Reservation> updateClient(@PathVariable("numberReservation") String numberReservation,
			ReservationVO reservationVo) {
		Reservation reservation = this.reservationService.findByNumberReservation(numberReservation);
		if (reservation == null) {
			return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
		} else {
			reservation.setReservationStartDate(reservationVo.getReservationStartDate());
			reservation.setReservationEndDate(reservationVo.getReservationEndDate());
			reservation.setAmountPeople(reservationVo.getAmountPeople());
		}

		return new ResponseEntity<Reservation>(this.reservationService.update(reservation), HttpStatus.OK);
	}

	@DeleteMapping("/{numberReservation}")
	@ApiOperation(value = "Eliminar reserva", notes = "Servicio para eliminar una reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reserva eliminada correctamente"),
			@ApiResponse(code = 404, message = "Reserva no encontrada") })
	public void removeClient(@PathVariable("numberReservation") String numberReservation) {
		Reservation reservation = this.reservationService.findByNumberReservation(numberReservation);
		if (reservation != null) {
			this.reservationService.delete(reservation);
		}
	}

	@GetMapping("/{start}/{end}")
	@ApiOperation(value = "Listar reservas", notes = "Servicio para listar reservas en un rango de fechas")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reservas encontradas"),
			@ApiResponse(code = 404, message = "Reservas no encontradas") })
	public ResponseEntity<List<Reservation>> find(@PathVariable("start") Date start, @PathVariable("end") Date end) {
		return ResponseEntity.ok(this.reservationService.find(start, end));
	}
}
