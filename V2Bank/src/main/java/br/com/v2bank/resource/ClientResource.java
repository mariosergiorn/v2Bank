package br.com.v2bank.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import br.com.v2bank.dto.ClientConverterDTO;
import br.com.v2bank.dto.ClientDTO;
import br.com.v2bank.service.ClientService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
public class ClientResource {
	
	private final ClientService service;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO dto) {
		return ResponseEntity.ok(ClientConverterDTO.convertToClientDTO(this.service.create(ClientConverterDTO.convertToClient(dto))));
	}
	
	@GetMapping("/buscar-id/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ClientDTO> getClientById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(ClientConverterDTO.convertToClientDTO(this.service.getById(id).get()));
	}
	
	@GetMapping("/buscar-nome/{name}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ClientDTO> getClientByName(@PathVariable("name") String name) {
		return ResponseEntity.ok(ClientConverterDTO.convertToClientDTO(this.service.getByName(name).get()));
	}
	
	@GetMapping("/buscar-clientes")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<ClientDTO>> getAllClients() {
		return ResponseEntity.ok(ClientConverterDTO.conveterListClients(this.service.getAll()));
	}
	
	@PutMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<ClientDTO> updateClient(@Valid @RequestBody ClientDTO dto,@RequestParam("id") Long id) throws Exception {
		return ResponseEntity.ok(ClientConverterDTO.convertToClientDTO(this.service.update(this.service.getById(id).get(),dto)));	
	
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Void> deleteClientById (@PathVariable("id") Long id) {
		
		try {
			this.service.removeById(id);
			return ResponseEntity.ok().build();
			
		} catch (Exception e){
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("/remover/{name}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Void> deleteClientByName (@PathVariable("name") String name) {
		
		try {
			this.service.removeByName(name);
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
}
