package tn.esprit.spring.repository;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Facture;









@Repository

public interface BillRepository extends CrudRepository<Facture,Long>{

	

	@Query(value = "SELECT typepayment FROM facture f WHERE id=?1", nativeQuery = true)
	public String get_payment_type_by_id(Long id);

	@Query(value = "SELECT * FROM facture WHERE id=?1", nativeQuery = true)
	public Facture getOne(long id);

	
	

	



	

   


	
}



	







