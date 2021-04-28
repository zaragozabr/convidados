package br.com.fiap.convidados.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.convidados.dto.ConvidadoDto;
import br.com.fiap.convidados.entity.ConvidadoEntity;
import br.com.fiap.convidados.repository.ConvidadosRepository;
import br.com.fiap.convidados.service.ConvidadoService;
@Service
public class ConvidadoServiceImpl implements ConvidadoService {

	@Autowired
	ConvidadosRepository repository;

	@Override
	public List<ConvidadoDto> findAll() {
		List<ConvidadoEntity> listaConvidados = repository.findAll();
		List<ConvidadoDto> listaDtoConvidados = fromConvidadoEntityToConvidadoDto(listaConvidados);
		return listaDtoConvidados;
	}

	@Override
	public ConvidadoDto save(ConvidadoDto dto) {

		ConvidadoEntity entity = dto.toConvidadoEntity();
		entity = repository.save(entity);
		ConvidadoDto convidadoDto = fromConvidadoEntityToConvidadoDto(entity);

		return convidadoDto;
	}

	@Override
	public ConvidadoDto findById(Long id) {
		ConvidadoEntity entity = repository.findById(id).get();
		ConvidadoDto convidadoDto = fromConvidadoEntityToConvidadoDto(entity);
		
		return convidadoDto ;
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	private List<ConvidadoDto> fromConvidadoEntityToConvidadoDto(List<ConvidadoEntity> listaConvidados) {
		List<ConvidadoDto> listaConvidadoDto = new ArrayList<ConvidadoDto>();

		for (ConvidadoEntity entity : listaConvidados) {
			ConvidadoDto convidadoDto = new ConvidadoDto();
			convidadoDto.setAcompanhantes(entity.getAcompanhantes());
			convidadoDto.setNome(entity.getNome());
			convidadoDto.setId(entity.getId());
			convidadoDto.setEmail(entity.getEmail());
			listaConvidadoDto.add(convidadoDto);
		}
		return listaConvidadoDto;
	}

	private ConvidadoDto fromConvidadoEntityToConvidadoDto(ConvidadoEntity convidadoEntity) {

		ConvidadoDto convidadoDto = new ConvidadoDto();
		convidadoDto.setAcompanhantes(convidadoEntity.getAcompanhantes());
		convidadoDto.setNome(convidadoEntity.getNome());
		convidadoDto.setId(convidadoEntity.getId());
		convidadoDto.setEmail(convidadoEntity.getEmail());

		return convidadoDto;
	}
}
