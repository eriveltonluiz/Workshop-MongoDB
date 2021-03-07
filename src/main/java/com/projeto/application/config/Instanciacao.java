package com.projeto.application.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.projeto.application.model.AutorDTO;
import com.projeto.application.model.ComentarioDTO;
import com.projeto.application.model.Post;
import com.projeto.application.model.Usuario;
import com.projeto.application.repository.PostRepository;
import com.projeto.application.repository.UsuarioRepository;

@Configuration
public class Instanciacao implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		usuarioRepository.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Nunes", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Santos", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Anderson", "bob@gmail.com");
		
		usuarioRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post = new Post(null, sdf.parse("20/06/2019"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AutorDTO(maria));
		Post post1 = new Post(null, sdf.parse("22/06/2019"), "Bom dia", "Acordei feliz hoje!", new AutorDTO(maria));
	
		ComentarioDTO c1 = new ComentarioDTO("Boa viagem mano!", sdf.parse("20/06/2019"), new AutorDTO(alex));
		ComentarioDTO c2 = new ComentarioDTO("Aproveite!", sdf.parse("20/06/2019"), new AutorDTO(bob));
		ComentarioDTO c3 = new ComentarioDTO("Tenha um ótimo dia!", sdf.parse("22/06/2019"), new AutorDTO(alex));
		
		post.getComentarios().addAll(Arrays.asList(c1, c2));
		post1.getComentarios().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post,post1));
		
		maria.getPosts().addAll(Arrays.asList(post, post1));
		usuarioRepository.save(maria);
	}

}
