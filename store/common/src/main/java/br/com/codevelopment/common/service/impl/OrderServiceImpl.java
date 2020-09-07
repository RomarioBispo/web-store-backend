package br.com.codevelopment.common.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.codevelopment.common.domain.model.Order;
import br.com.codevelopment.common.domain.model.dto.OrderDTO;
import br.com.codevelopment.common.exception.UserNotFoundException;
import br.com.codevelopment.common.repository.OrderRepository;
import br.com.codevelopment.common.service.contract.OrderService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
	private final OrderRepository orderRepository;
	private final ModelMapper mapper;

	@Override
	public void create(OrderDTO orderDTO) {
		Order order = mapper.map(orderDTO, Order.class);
		orderRepository.save(order);
	}

	@Override
	public void update(OrderDTO orderDTO, String id) {
		Optional<Order> opt = orderRepository.findById(id);
		checkExists(opt);
		orderRepository.save(opt.get());
	}

	@Override
	public OrderDTO findById(String id) {
		Optional<Order> opt = orderRepository.findById(id);
		checkExists(opt);
		return mapper.map(opt.get(), OrderDTO.class);
	}

	@Override
	public List<OrderDTO> findAll() {
		return orderRepository
				.findAll()
				.stream()
				.map(item -> mapper.map(item, OrderDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteById(String id) {
		Optional<Order> opt = orderRepository.findById(id);
		checkExists(opt);
		orderRepository.deleteById(id);
	}
	
	private void checkExists(Optional<Order> user) {
		if (!user.isPresent()) {
			 throw new UserNotFoundException("NOT FOUND");
		}
	}

}
