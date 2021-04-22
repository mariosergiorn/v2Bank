/**
 * 
 */
package br.com.v2bank.dto;

import br.com.v2bank.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Mario Sergio
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferDTO {
	
	private Account sourceAccount;
	
	private Account destinationAccount;
	
	private Double value;

}
