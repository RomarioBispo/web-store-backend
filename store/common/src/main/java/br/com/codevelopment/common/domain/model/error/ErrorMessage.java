package br.com.codevelopment.common.domain.model.error;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class ErrorMessage {
	private LocalDateTime timestamp;
	private String message;
	private String reason;
	private String path;
}
