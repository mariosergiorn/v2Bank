package br.com.v2bank.service;

import java.util.List;
import java.util.Optional;

import br.com.v2bank.dto.ClientDTO;
import br.com.v2bank.entity.Client;

public interface ClientService {
	
	Client create(Client client);
	
	Client update(Client client, ClientDTO clientDTO);
	
	Optional<Client> getById(Long id);
	
	List<Client> getAll();
	
	Optional<Client> getByName(String name);
	
	void removeById(Long id) throws Exception;
	
	void removeByName(String name) throws Exception;
	
}
