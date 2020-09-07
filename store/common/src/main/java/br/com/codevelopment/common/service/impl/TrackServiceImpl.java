package br.com.codevelopment.common.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.codevelopment.common.domain.model.Track;
import br.com.codevelopment.common.domain.model.dto.TrackDTO;
import br.com.codevelopment.common.exception.UserNotFoundException;
import br.com.codevelopment.common.repository.TrackRepository;
import br.com.codevelopment.common.service.contract.TrackService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TrackServiceImpl implements TrackService {
	private final TrackRepository trackRepository;
	private final ModelMapper mapper;

	@Override
	public void create(TrackDTO trackDTO) {
		Track track = mapper.map(trackDTO, Track.class);
		trackRepository.save(track);
	}

	@Override
	public void update(TrackDTO trackDTO, String id) {
		Optional<Track> opt = trackRepository.findById(id);
		checkExists(opt);
		trackRepository.save(opt.get());
	}

	@Override
	public TrackDTO findById(String id) {
		Optional<Track> opt = trackRepository.findById(id);
		checkExists(opt);
		return mapper.map(opt.get(), TrackDTO.class);
	}

	@Override
	public List<TrackDTO> findAll() {
		return trackRepository
				.findAll()
				.stream()
				.map(item -> mapper.map(item, TrackDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteById(String id) {
		Optional<Track> opt = trackRepository.findById(id);
		checkExists(opt);
		trackRepository.deleteById(id);
	}
	
	private void checkExists(Optional<Track> user) {
		if (!user.isPresent()) {
			 throw new UserNotFoundException("NOT FOUND");
		}
	}

}
