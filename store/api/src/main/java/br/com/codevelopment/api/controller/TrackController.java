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

import br.com.codevelopment.common.domain.model.dto.TrackDTO;
import br.com.codevelopment.common.service.contract.TrackService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/track")
@RequiredArgsConstructor	
public class TrackController {
	
	private final TrackService trackService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	@ResponseBody
	public void createTrack(@RequestBody TrackDTO trackDTO) {
		trackService.create(trackDTO);
	}
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<TrackDTO> findAllTrack() {
		return trackService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public TrackDTO findTrackById(@PathVariable String id) {
		return trackService.findById(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody()
	public void updateTrack(@PathVariable String id, @RequestBody TrackDTO trackDTO) {
		trackService.update(trackDTO, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@ResponseBody()
	public void deleteTrack(@PathVariable String id) {
		trackService.deleteById(id);
	}

}
