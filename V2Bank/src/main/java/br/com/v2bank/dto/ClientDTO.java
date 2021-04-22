package br.com.v2bank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDTO {
	
	private String name;
	
	private String address;
	
	private String email;
	
	private String phone;
	
	private String cpfOuCnjp;
}
