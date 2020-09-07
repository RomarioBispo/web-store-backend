package br.com.codevelopment.common.domain.model.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class OrderDTO {
	private String userId;
	private String productId;
	private String trackId; 
	private String status;
	private Double amount;
	private String paymentType;
	private Address deliveryAddress;
	private Address paymentAddress;
	private Boolean paymentSituation;
	
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
