/**
 * 
 */
package com.jrsaavedra.ereservation.view.resource.vo;

import lombok.Data;

/**
 * Clase que representa a la tabla Client Virtual
 * @author Jrsaavedra
 *
 */

@Data 
public class ClientVO {
	private String name;
	private String lastName;
	private String document;
	private String address;
	private String phone;
	private String email;
	
}
