package br.com.codevelopment.common.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Document(collection = "course")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Course implements AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonIgnore
	@EqualsAndHashCode.Include
	private String id;
	
	private String title;
	
	@Override
	public String getId() {
		return id;
	}
	

}
