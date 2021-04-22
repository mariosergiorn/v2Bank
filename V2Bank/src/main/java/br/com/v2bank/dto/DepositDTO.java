/**
 * 
 */
package br.com.v2bank.dto;

import java.io.Serializable;

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
public class DepositDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2837101586125763986L;

	private Account account;
	
	private Double value;

}
