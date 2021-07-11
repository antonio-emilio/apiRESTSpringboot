package com.algaworks.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.algaworks.crm.model.*;
import com.algaworks.crm.repository.ClienteRepository;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@RestController
//@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:333")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public ResponseEntity<Page<Cliente>> getAllLives(@PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable){
        Page<Cliente> clientPage = clienteRepository.findAll(pageable);
        if(clientPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Page<Cliente>>(clientPage, HttpStatus.OK);
        }
    }
	
	
	@GetMapping("/cliente/{id}")
	public Cliente listarUm(@PathVariable(value="id") long id) {
		return clienteRepository.findById(id);
	}
	
	@GetMapping("/cliente/bobino")
	public ResponseEntity <List<Cliente>> whereIsBobino() {
		return new ResponseEntity<>(clienteRepository.getTheUserBobino(), HttpStatus.OK);
	}
	
	@DeleteMapping("/cliente/{id}")
	public void deletarUm(@PathVariable(value="id") long id) {
		clienteRepository.deleteById(id);
	}
	
	@PutMapping("/cliente/{id}")
	public Cliente atualizarUm(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
		
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar (@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
