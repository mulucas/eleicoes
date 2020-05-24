package com.reserva.horario.eleicoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.reserva.horario.eleicoes.models.Estado;
import com.reserva.horario.eleicoes.models.Municipio;
import com.reserva.horario.eleicoes.repository.EstadoRepository;
import com.reserva.horario.eleicoes.repository.MunicipioRepository;

@Controller
public class IndexController {
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	MunicipioRepository cidadeRepository;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		Iterable<Estado> estadoIt = estadoRepository.findAll();
		modelAndView.addObject("estados", estadoIt);
		
		Iterable<Municipio> cidadeIt = cidadeRepository.findAll();
		modelAndView.addObject("cidades", cidadeIt);
		
		return modelAndView;
	}
	
}
