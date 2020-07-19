package com.projeto.application.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.projeto.application.model.Usuario;
import com.projeto.application.repository.UsuarioRepository;

@Configuration
public class Instanciacao implements CommandLineRunner{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		repository.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Nunes", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Santos", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Anderson", "bob@gmail.com");
	
		repository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
