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

import br.com.codevelopment.common.domain.model.dto.ApplicationUserDTO;
import br.com.codevelopment.common.service.contract.UserApplicationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor	
public class UserController {
	
	private final UserApplicationService userService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	@ResponseBody
	public void createUser(@RequestBody ApplicationUserDTO userDTO) {
		userService.create(userDTO);
	}
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ApplicationUserDTO> findAll() {
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public ApplicationUserDTO findById(@PathVariable String id) {
		return userService.findById(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody()
	public void updateUser(@PathVariable String id, @RequestBody ApplicationUserDTO userDTO) {
		userService.update(userDTO, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@ResponseBody()
	public void deleteUser(@PathVariable String id) {
		userService.deleteById(id);
	}

}
