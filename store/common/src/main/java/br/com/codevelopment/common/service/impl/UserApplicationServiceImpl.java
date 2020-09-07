package br.com.codevelopment.common.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.codevelopment.common.domain.model.ApplicationUser;
import br.com.codevelopment.common.domain.model.dto.ApplicationUserDTO;
import br.com.codevelopment.common.exception.UserNotFoundException;
import br.com.codevelopment.common.repository.ApplicationUserRepository;
import br.com.codevelopment.common.service.contract.UserApplicationService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserApplicationServiceImpl implements UserApplicationService {
	private final ApplicationUserRepository userRepository;
	private final ModelMapper mapper;
	private final BCryptPasswordEncoder encoder;

	@Override
	public void create(ApplicationUserDTO userDTO) {
		ApplicationUser user = mapper.map(userDTO, ApplicationUser.class);
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public void update(ApplicationUserDTO userDTO, String id) {
		ApplicationUser user = mapper.map(userDTO, ApplicationUser.class);
		user.setId(id);
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public ApplicationUserDTO findById(String id) {
		Optional<ApplicationUser> opt = userRepository.findById(id);
		checkUserExists(opt);
		return mapper.map(opt.get(), ApplicationUserDTO.class);
	}

	@Override
	public List<ApplicationUserDTO> findAll() {
		return userRepository
				.findAll()
				.stream()
				.map(item -> mapper.map(item, ApplicationUserDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteById(String id) {
		Optional<ApplicationUser> opt = userRepository.findById(id);
		checkUserExists(opt);
		userRepository.deleteById(id);
	}
	
	private void checkUserExists(Optional<ApplicationUser> user) {
		if (!user.isPresent()) {
			 throw new UserNotFoundException("USER NOT FOUND");
		}
	}

}
