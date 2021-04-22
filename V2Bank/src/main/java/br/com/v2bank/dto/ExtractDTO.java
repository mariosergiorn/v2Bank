/**
 * 
 */
package br.com.v2bank.dto;

/**
 * @author Mario Sergio
 *
 */

import java.time.LocalDate;

import br.com.v2bank.enums.TypeOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExtractDTO {

	private LocalDate dateTransaction;
	
	private int originAgency;
	
	private int originAccount;
		
	private int destinationAgency;
	
	private int destinationAccount;

	private TypeOperation typeOperation;
	
	private String valueTransaction;
	
	private Double balance;
	
}