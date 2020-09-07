package br.com.codevelopment.common.service.contract;

import java.util.List;

import br.com.codevelopment.common.domain.model.dto.TrackDTO;

public interface TrackService {
	public void create(TrackDTO user);
	public void update(TrackDTO user, String id);
	public TrackDTO findById(String id);
	public List<TrackDTO> findAll();
	public void deleteById(String id);
}
