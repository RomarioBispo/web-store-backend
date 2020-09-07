package br.com.codevelopment.common.domain.model.dto;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@Document(collection = "track")
@JsonInclude(Include.NON_NULL)
public class TrackDTO {
	private Double latitude;
	private Double longitude;
	private String trackStatus;
	private String description;
	private LocalDateTime lastUpdate;
}
