package com.reserva.horario.eleicoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "com.reserva.horario.eleicoes.models")
@ComponentScan(basePackages = "com.reserva.horario.eleicoes.*")
@EnableJpaRepositories(basePackages = "com.reserva.horario.eleicoes.repository")
@EnableTransactionManagement
public class EleicoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EleicoesApplication.class, args);
	}

}
