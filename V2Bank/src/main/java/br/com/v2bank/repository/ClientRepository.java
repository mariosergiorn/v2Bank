package br.com.v2bank.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.v2bank.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	Optional<Client> findByName(String name);
	
	void deleteByName(String name);
	
}
