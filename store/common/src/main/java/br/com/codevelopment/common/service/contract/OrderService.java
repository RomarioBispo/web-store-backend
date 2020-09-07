package br.com.codevelopment.common.service.contract;

import java.util.List;

import br.com.codevelopment.common.domain.model.dto.OrderDTO;

public interface OrderService {
	public void create(OrderDTO user);
	public void update(OrderDTO user, String id);
	public OrderDTO findById(String id);
	public List<OrderDTO> findAll();
	public void deleteById(String id);
}
