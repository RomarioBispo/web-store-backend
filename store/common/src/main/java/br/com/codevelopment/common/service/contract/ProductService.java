package br.com.codevelopment.common.service.contract;

import java.util.List;

import br.com.codevelopment.common.domain.model.dto.ProductDTO;

public interface ProductService {
	public void create(ProductDTO user);
	public void update(ProductDTO user, String id);
	public ProductDTO findById(String id);
	public List<ProductDTO> findAll();
	public void deleteById(String id);
}
