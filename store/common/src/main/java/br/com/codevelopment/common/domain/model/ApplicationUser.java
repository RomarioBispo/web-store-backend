package br.com.codevelopment.common.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Document(collection = "applicationUser")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(Include.NON_NULL)
public class ApplicationUser implements AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	@EqualsAndHashCode.Include
	private String id;

	@Indexed(name = "username_index", unique = true)
	private String username;
	
	private LocalDate birthDate;
	
	@Indexed(name = "rg_index", unique = true)
	private String rg;
	
	@Indexed(name = "cpf_index", unique = true)
	private String cpf;
	
	@Indexed(name = "email_index", unique = true)
	private String email;
	
	private String password;
	
	private Address address;
	
	@Builder.Default
	private String role = "USER";
	
	@Override
	public String getId() {
		return id;
	}

	public ApplicationUser(@NotNull ApplicationUser user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.role = user.getRole();
	}
	
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
