package com.projeto.application.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.application.model.Post;
import com.projeto.application.resources.util.URL;
import com.projeto.application.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/pesquisaTitulo")
	public ResponseEntity<List<Post>> encontrarTitlo(@RequestParam(value = "text", defaultValue = "") String texto){
		texto = URL.decodeParametro(texto);
		List<Post> posts = service.encontrarTitulo(texto);
		return ResponseEntity.ok().body(posts);
	}
}
