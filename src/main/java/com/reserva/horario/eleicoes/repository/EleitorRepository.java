package com.reserva.horario.eleicoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reserva.horario.eleicoes.models.Eleitor;

public interface EleitorRepository extends CrudRepository<Eleitor, Long>{

	@Query("select e from Eleitor e where e.secao.id = ?1")
	public List<Eleitor> getEleitores(Long secaoid) ;

	public static final String FIND_PROJECTS = "SELECT horario FROM eleitor";

	@Query(value = FIND_PROJECTS, nativeQuery = true)
	public List<String> findProjects();
	
}
