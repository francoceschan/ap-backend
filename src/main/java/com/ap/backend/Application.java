package com.ap.backend;

import com.ap.backend.dao.UsuarioDao;
import com.ap.backend.model.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

		/*
				ESTO SIRVE PARA CREAR UN USUARIO DESDE ACA PORQUE NO VOY A PONER OPCION DE REGISTRARSE (si se quiere usar comentar linea de arriba y descomentar esto)
		ApplicationContext context = SpringApplication.run(Application.class, args);

		UsuarioDao repository = context.getBean(UsuarioDao.class);

		PasswordEncoder encoder = context.getBean(PasswordEncoder.class);

		Usuario user = new Usuario(null, "Argentina", encoder.encode("Programa"));
		repository.save(user);

		*/

	}

}
