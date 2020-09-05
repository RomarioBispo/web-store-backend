package br.com.codevelopment.common.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.codevelopment.common.domain.model.ApplicationUser;

@Repository
public interface ApplicationUserRepository extends MongoRepository<ApplicationUser, String> {
	public ApplicationUser findByusername(String username);
}
