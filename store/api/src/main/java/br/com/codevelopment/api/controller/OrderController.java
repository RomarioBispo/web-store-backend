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

import br.com.codevelopment.common.domain.model.dto.OrderDTO;
import br.com.codevelopment.common.service.contract.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor	
public class OrderController {
	
	private final OrderService orderService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	@ResponseBody
	public void createOrder(@RequestBody OrderDTO orderDTO) {
		orderService.create(orderDTO);
	}
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<OrderDTO> findAllOrder() {
		return orderService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public OrderDTO findOrderById(@PathVariable String id) {
		return orderService.findById(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody()
	public void updateOrder(@PathVariable String id, @RequestBody OrderDTO userDTO) {
		orderService.update(userDTO, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@ResponseBody()
	public void deleteOrder(@PathVariable String id) {
		orderService.deleteById(id);
	}

}
