package com.reserva.horario.eleicoes.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reserva.horario.eleicoes.models.Secao;

@Repository
@Transactional
public interface SecaoRepository extends CrudRepository<Secao, Long> {

}
