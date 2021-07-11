package com.algaworks.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.algaworks.crm.model.*;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Cliente findById(long id);
	

	@Query ("SELECT u FROM Cliente u WHERE u.nome LIKE 'Bobino2'")
	public List <Cliente> getTheUserBobino ();

}


