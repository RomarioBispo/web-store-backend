package br.com.codevelopment.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.codevelopment.common.domain.model.dto.ProductDTO;
import br.com.codevelopment.common.service.contract.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor	
public class ProductController {
	
	private final ProductService poductService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	@ResponseBody
	public void createProduct(@RequestBody ProductDTO productDTO) {
		poductService.create(productDTO);
	}
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ProductDTO> findAllProduct() {
		return poductService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public ProductDTO findProductById(@PathVariable String id) {
		return poductService.findById(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody()
	public void updateProduct(@PathVariable String id, @RequestBody ProductDTO productDTO) {
		poductService.update(productDTO, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@ResponseBody()
	public void deleteProduct(@PathVariable String id) {
		poductService.deleteById(id);
	}

}
