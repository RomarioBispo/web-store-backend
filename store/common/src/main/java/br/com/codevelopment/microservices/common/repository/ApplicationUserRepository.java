package br.com.codevelopment.microservices.common.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.codevelopment.microservices.common.domain.model.ApplicationUser;

@Repository
public interface ApplicationUserRepository extends MongoRepository<ApplicationUser, String> {
	public ApplicationUser findByusername(String username);
}
