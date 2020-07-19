package com.projeto.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.application.dto.UsuarioDTO;
import com.projeto.application.model.Usuario;
import com.projeto.application.repository.UsuarioRepository;
import com.projeto.application.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(String id) {
		Optional<Usuario> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!!"));
	}
	
	public Usuario inserir(Usuario obj) {
		return repository.save(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Usuario atualizar(Usuario obj) {
		Usuario newObj = findById(obj.getId());
		atualizarDados(newObj, obj);
		return repository.save(newObj);
	}
	
	private void atualizarDados(Usuario newObj, Usuario obj) {
		 newObj.setNome(obj.getNome());
		 newObj.setEmail(obj.getEmail());
	}

	
	public Usuario fromDto(UsuarioDTO dto) {
		return new Usuario(dto.getId(), dto.getNome(), dto.getEmail());
	}
}
