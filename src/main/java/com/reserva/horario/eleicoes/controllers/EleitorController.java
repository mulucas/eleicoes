package com.reserva.horario.eleicoes.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.reserva.horario.eleicoes.models.Eleitor;
import com.reserva.horario.eleicoes.models.Secao;
import com.reserva.horario.eleicoes.repository.EleitorRepository;
import com.reserva.horario.eleicoes.repository.SecaoRepository;
import com.reserva.horario.eleicoes.validator.ValidarDados;

@Controller
public class EleitorController {

	@Autowired
	private SecaoRepository secaoRepository;

	@Autowired
	private EleitorRepository eleitorRepository;

	@PostMapping("**/addeleitor/{secaoid}")
	public ModelAndView addeleitor(@Valid Eleitor eleitor, @PathVariable("secaoid") Long secaoid) {
		ModelAndView andView = new ModelAndView("eleitores");
		Secao secao = secaoRepository.findById(secaoid).get();
		
		if (ValidarDados.ValidarTitulo(eleitor.getNumeroTitulo()) && ValidarDados.validarHorario(eleitor.getHorario())) {

			if (verificaQntdEleitores(eleitor)) {
				eleitor.setSecao(secao);
				eleitorRepository.save(eleitor);
			} else {
				andView.addObject("msg", "Esse horario ja esta com o numero de eleitores maximo permitido, por afvor escolha outro horario");
			}
		} else {
			andView.addObject("msg", "Por favor, confira se os dados informado abaixo estao corretos");
		}
		andView.addObject("secaoobj", secao);
		andView.addObject("eleitores", eleitorRepository.getEleitores(secaoid));
		return andView;
	}

	@GetMapping("/eleitores/{idsecao}")
	public ModelAndView eleitores(@PathVariable("idsecao") Long idsecao) {
		ModelAndView andView = new ModelAndView("eleitores");
		Optional<Secao> secao = secaoRepository.findById(idsecao);
		andView.addObject("eleitores", eleitorRepository.getEleitores(idsecao));
		andView.addObject("secaoobj", secao.get());
		return andView;
	}

	public boolean verificaQntdEleitores(Eleitor eleitor) {
		List<String> lista = eleitorRepository.findProjects();
		String horarioEleitor = eleitor.getHorario().substring(0, 2);
		String horarioBd;
		int contador = 0;
		for (String string : lista) {
			horarioBd = string.substring(0, 2);
			if (horarioEleitor.equals(horarioBd)) {
				contador++;
			}
			if (contador == 12) {
				return false;
			}
		}
		return true;
	}
}
