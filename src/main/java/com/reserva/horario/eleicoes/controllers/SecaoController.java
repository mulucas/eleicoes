package com.reserva.horario.eleicoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reserva.horario.eleicoes.models.Secao;
import com.reserva.horario.eleicoes.repository.SecaoRepository;

@Controller
public class SecaoController {
	
	@Autowired
	private SecaoRepository secaoRepository;

	@RequestMapping(method = RequestMethod.GET, value="/listasecoes")
	public ModelAndView secoes() {
		ModelAndView andView = new ModelAndView("listasecoes");
		Iterable<Secao> secoesIt = secaoRepository.findAll();
		andView.addObject("secoes", secoesIt);
		return andView;
	}
	
}
