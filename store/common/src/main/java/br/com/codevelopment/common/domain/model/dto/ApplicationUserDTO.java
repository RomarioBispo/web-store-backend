package br.com.codevelopment.common.domain.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ApplicationUserDTO {

	private String id;
	
	private String username;
	
	private LocalDate birthDate;
	
	private String rg;
	
	private String cpf;
	
	private String email;
	
	private String password;
	
	private Address address;
	
	@Data
	public static class Address implements Serializable {
		private static final long serialVersionUID = 10L;
		private String country;
		private String state;
		private String city;
		private String zipcode;
		private String street;
		private int number;
	}
}
