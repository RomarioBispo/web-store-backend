package br.com.codevelopment.common.domain.model.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ProductDTO {
	private String name;
	private Double price;
	private Integer quantity;
	private Double ship;
	private String description;
	private Integer rating;
	private LocalDateTime date;
	private String photoUrl;
	
}
