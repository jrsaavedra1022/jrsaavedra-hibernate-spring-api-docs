package com.jrsaavedra.ereservation.view.resource;

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

import com.jrsaavedra.ereservation.business.service.ClientService;
import com.jrsaavedra.ereservation.model.Client;
import com.jrsaavedra.ereservation.view.resource.vo.ClientVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el servicio web de Cliente
 * 
 * @author Jrsaavedra
 *
 */

@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ClientResource {
	private final ClientService clientService;

	public ClientResource(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping
	@ApiOperation(value = "Crear Cliente", notes = "Servicio para crear un nuevo cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud inválida") })
	public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVo) {
		Client client = new Client();
		client.setName(clientVo.getName());
		client.setLastName(clientVo.getLastName());
		client.setAddress(clientVo.getAddress());
		client.setPhone(clientVo.getPhone());
		client.setEmail(clientVo.getEmail());

		return new ResponseEntity<Client>(this.clientService.create(client), HttpStatus.CREATED);
	}

	@PutMapping("/{document}")
	@ApiOperation(value = "Actualizar Cliente", notes = "Servicio para actualizar un cliente existente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") })
	public ResponseEntity<Client> updateClient(@PathVariable("document") String document, ClientVO clientVo) {
		Client client = this.clientService.findByDocument(document);
		if (client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		} else {
			client.setName(clientVo.getName());
			client.setLastName(clientVo.getLastName());
			client.setAddress(clientVo.getAddress());
			client.setPhone(clientVo.getPhone());
			client.setEmail(clientVo.getEmail());
		}

		return new ResponseEntity<Client>(this.clientService.update(client), HttpStatus.OK);
	}

	@DeleteMapping("/{document}")
	@ApiOperation(value = "Eliminar Cliente", notes = "Servicio para eliminar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") })
	public void removeClient(@PathVariable("document") String document) {
		Client client = this.clientService.findByDocument(document);
		if (client != null) {
			this.clientService.delete(client);
		}
	}

	@GetMapping
	@ApiOperation(value = "Listar Clientes", notes = "Servicio para listar todos los clientes")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Clientes encontrados"),
			@ApiResponse(code = 404, message = "Clientes no encontrados") })
	public ResponseEntity<List<Client>> findAll() {
		return ResponseEntity.ok(this.clientService.findAll());
	}

}
