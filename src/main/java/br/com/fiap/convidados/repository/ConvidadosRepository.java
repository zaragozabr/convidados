package br.com.fiap.convidados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.convidados.entity.ConvidadoEntity;

public interface ConvidadosRepository extends JpaRepository<ConvidadoEntity, Long> {

}
