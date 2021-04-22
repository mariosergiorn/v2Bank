/**
 * 
 */
package br.com.v2bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.v2bank.entity.Extract;

/**
 * @author Mario Sergio
 *
 */

@Repository
public interface ExtractRepository extends JpaRepository<Extract, Long> {

}
