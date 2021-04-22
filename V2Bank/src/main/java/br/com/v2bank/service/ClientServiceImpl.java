package br.com.v2bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.v2bank.dto.ClientDTO;
import br.com.v2bank.entity.Client;
import br.com.v2bank.exceptions.ClientNotFoundException;
import br.com.v2bank.repository.ClientRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{
	
	private final ClientRepository repository;

	@Override
	public Client create(Client client) {
		return this.repository.save(client);
	}

	@Override
	public List<Client> getAll() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Client> getById(Long id) {
		return this.repository.findById(id);
	}
	
	@Override
	public Optional<Client> getByName(String nome) {
		return this.repository.findByName(nome);
	}
	
	@Override
	public void removeById(Long id) throws Exception {
		if (this.repository.findById(id).get() != null) {
			this.repository.deleteById(id);
		} else {
			throw new ClientNotFoundException(HttpStatus.NOT_FOUND, "Client not found");
		}
	}

	@Override
	public void removeByName(String name) throws Exception {
		if (this.repository.findByName(name).get() != null) {
			this.repository.deleteByName(name);
		} else {
			
			throw new ClientNotFoundException(HttpStatus.NOT_FOUND, "Client no content!");
		}
		
	}

	@Override
	public Client update(Client client, ClientDTO clientDTO) {
		
		client.setName(clientDTO.getName().isBlank() ? client.getName() : clientDTO.getName());
		
		client.setAddress(clientDTO.getAddress().isBlank() ? client.getAddress() : clientDTO.getAddress());
		
		client.setEmail(clientDTO.getEmail().isBlank() ? client.getEmail() : clientDTO.getEmail());
		
		client.setPhone(clientDTO.getPhone().isBlank() ? client.getPhone() : clientDTO.getPhone());
		
		client.setCpfOuCnjp(clientDTO.getCpfOuCnjp().isBlank() ? client.getCpfOuCnjp() : clientDTO.getCpfOuCnjp());
		
		return this.repository.save(client);
	}

}
