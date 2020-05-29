package com.reserva.horario.eleicoes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConsultaController {

	@RequestMapping("/consultar")
	public String consulta () {
		return "consulta";
	}
}
