package tn.esprit.spring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Delivery;



@Repository
public interface IDeliveryRepository extends JpaRepository<Delivery, Long>{
	@Modifying
	@Transactional
	@Query(value="delete from Delivery d where d.id = ?1")
	void deleteDeliveryById(Long id);
}
