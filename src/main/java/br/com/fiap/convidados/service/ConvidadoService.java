package br.com.fiap.convidados.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.convidados.dto.ConvidadoDto;

@Service
public interface ConvidadoService {

	List<ConvidadoDto> findAll();

	ConvidadoDto save(ConvidadoDto convidadoDto);

	ConvidadoDto findById(Long id);

	void deleteById(Long id);

}
