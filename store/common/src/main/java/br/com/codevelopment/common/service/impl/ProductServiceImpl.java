package br.com.codevelopment.common.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.codevelopment.common.domain.model.Product;
import br.com.codevelopment.common.domain.model.dto.ProductDTO;
import br.com.codevelopment.common.exception.UserNotFoundException;
import br.com.codevelopment.common.repository.ProductRepository;
import br.com.codevelopment.common.service.contract.ProductService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;
	private final ModelMapper mapper;

	@Override
	public void create(ProductDTO productDTO) {
		Product product = mapper.map(productDTO, Product.class);
		productRepository.save(product);
	}

	@Override
	public void update(ProductDTO productDTO, String id) {
		Optional<Product> opt = productRepository.findById(id);
		checkExists(opt);
		productRepository.save(opt.get());
	}

	@Override
	public ProductDTO findById(String id) {
		Optional<Product> opt = productRepository.findById(id);
		checkExists(opt);
		return mapper.map(opt.get(), ProductDTO.class);
	}

	@Override
	public List<ProductDTO> findAll() {
		return productRepository
				.findAll()
				.stream()
				.map(item -> mapper.map(item, ProductDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteById(String id) {
		Optional<Product> opt = productRepository.findById(id);
		checkExists(opt);
		productRepository.deleteById(id);
	}
	
	private void checkExists(Optional<Product> user) {
		if (!user.isPresent()) {
			 throw new UserNotFoundException("NOT FOUND");
		}
	}

}
