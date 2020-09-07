package br.com.codevelopment.common.service;

import java.util.List;

import br.com.codevelopment.common.domain.model.dto.ApplicationUserDTO;

public interface UserApplicationService {
	public void create(ApplicationUserDTO user);
	public void update(ApplicationUserDTO user, String id);
	public ApplicationUserDTO findById(String id);
	public List<ApplicationUserDTO> findAll();
	public void deleteById(String id);
}
