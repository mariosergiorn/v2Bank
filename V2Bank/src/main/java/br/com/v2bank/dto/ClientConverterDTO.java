package br.com.v2bank.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.v2bank.entity.Client;

@Component
public class ClientConverterDTO {
	
	@Bean
	public static ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static Client convertToClient(ClientDTO dto) {
		return modelMapper().map(dto, Client.class);
	}
	
	public static ClientDTO convertToClientDTO(Client client) {
		return modelMapper().map(client, ClientDTO.class);
	}
	
	public static List<ClientDTO> conveterListClients(List<Client> clients){
		return clients
				.stream()
				.map(c -> modelMapper().map(c, ClientDTO.class))
				.collect(Collectors.toList());
	}

}
