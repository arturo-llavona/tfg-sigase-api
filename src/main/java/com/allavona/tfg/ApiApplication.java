package com.allavona.tfg;

import com.allavona.tfg.business.service.RecursosService;
import com.allavona.tfg.business.service.UsuariosService;
import com.allavona.tfg.business.service.impl.RecursosServiceImpl;
import com.allavona.tfg.business.service.impl.UsuariosServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	public UsuariosService usuariosService() {
		return new UsuariosServiceImpl();
	}

	@Bean
	public RecursosService recursosService() { return new RecursosServiceImpl(); }

}
