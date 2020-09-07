package br.com.codevelopment.common.domain.model.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class TrackDTO {
	private Double latitude;
	private Double longitude;
	private String trackStatus;
	private String description;
	private LocalDateTime lastUpdate;
}
