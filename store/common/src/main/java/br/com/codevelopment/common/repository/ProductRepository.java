package br.com.codevelopment.common.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.codevelopment.common.domain.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
