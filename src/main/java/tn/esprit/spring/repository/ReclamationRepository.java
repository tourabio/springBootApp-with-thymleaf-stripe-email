package tn.esprit.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entities.Reclamations;


public interface ReclamationRepository extends JpaRepository<Reclamations, Long> {
	@Modifying
	@Transactional
	@Query(value="delete from Reclamations r where r.id = ?1")
	void deleteReclamationById(Long id);
}
