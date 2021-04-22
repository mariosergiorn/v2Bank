package br.com.v2bank.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "tb_clients")
public class Client implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_Client")
	private Long id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Phone")
	private String phone;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="CPForCNPJ", unique=true)
	private String cpfOuCnjp;
}
