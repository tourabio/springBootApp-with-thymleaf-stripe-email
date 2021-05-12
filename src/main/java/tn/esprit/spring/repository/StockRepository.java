package tn.esprit.spring.repository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entities.Stock;
import java.util.List;
import org.springframework.data.jpa.repository.Query;


public interface StockRepository extends CrudRepository<Stock , Integer> {
	
	@Query(value="SELECT u FROM Stock u WHERE u.QuantityStock=0")
	public List<Stock> OutOfStockDetector();
	@Query(value = "SELECT * FROM Stock WHERE id_stock=?1", nativeQuery = true)
	public Stock getOne(long id);

} 