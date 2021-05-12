package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Reclamations;



public interface ReclamationService {

	List<Reclamations> retrieveAllReclamations();
	Reclamations addReclamation(Reclamations r);
	void deleteReclamation(Long id);
	void updateReclamation(Reclamations r);
	Optional<Reclamations> retrieveReclamation(Long id);	
}
