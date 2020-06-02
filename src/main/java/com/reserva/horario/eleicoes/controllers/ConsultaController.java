package com.reserva.horario.eleicoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.reserva.horario.eleicoes.repository.EleitorRepository;

@Controller
public class ConsultaController {
	
	@Autowired
	EleitorRepository eleitorRepository;

	@RequestMapping("/consultar")
	public String consulta () {
		return "consulta";
	}
	@PostMapping("**/consultarhorario")
	public ModelAndView pesquisar(@RequestParam("nomepesquisa") String nomepesquisa, @RequestParam("numTitulo") String numTitulo) {
		ModelAndView andView = null;
		if (eleitorRepository.findEleitorByNome(nomepesquisa) == eleitorRepository.findEleitorByTitulo(numTitulo)) {
			andView = new ModelAndView("resultadoConsulta");
			andView.addObject("pessoas", eleitorRepository.findEleitorByNome(nomepesquisa));
		}else {
			andView = new ModelAndView("consulta");
			andView.addObject("msg", "Por favor, confira se os dados informado abaixo estao corretos");
		}
		return andView;
	}
}
