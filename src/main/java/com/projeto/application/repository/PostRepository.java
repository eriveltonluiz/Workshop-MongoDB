package com.projeto.application.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto.application.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
	List<Post> pesquisaTitulo(String texto);
	
	List<Post> findByTituloContainingIgnoreCase(String titulo);
	
}
