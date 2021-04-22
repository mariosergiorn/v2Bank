package br.com.v2bank.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.v2bank.enums.TypeAccountEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="tb_accounts")
public class Account implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "Id_Client"))
	private Client client;
	
	@Enumerated(EnumType.STRING)
	private TypeAccountEnum typeAccount;
	
	@Column(name="number_account")
	private int numberAccount;
	
	@Column(name="number_agengy")
	private int numberAgency;
	
	@Column(columnDefinition = "DECIMAL(10,2) DEFAULT 0")
	private Double balance;
	

}
