package com.algaworks.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.algaworks.crm.model.*;
import com.algaworks.crm.repository.ClienteRepository;

@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/cliente/{id}")
	public Cliente listarUm(@PathVariable(value="id") long id) {
		return clienteRepository.findById(id);
	}
	
	@DeleteMapping("/clientes")
	public void deletarUm(@RequestBody Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
	@PutMapping("/clientes")
	public Cliente atualizarUm(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
		
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar (@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
