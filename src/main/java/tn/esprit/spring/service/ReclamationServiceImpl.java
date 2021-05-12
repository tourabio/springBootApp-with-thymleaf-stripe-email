package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Reclamations;
import tn.esprit.spring.repository.ReclamationRepository;

@Service
public class ReclamationServiceImpl implements ReclamationService{

	@Autowired
	ReclamationRepository reclamationRepository;
	
	public static final Logger l= LogManager.getLogger(ReclamationServiceImpl.class);

	
	
	@Override
	public List<Reclamations> retrieveAllReclamations() {
		List<Reclamations> reclamations = (List<Reclamations>)reclamationRepository.findAll(); 
		for  (Reclamations reclamation : reclamations) {
			l.info("reclamation +++ : "+reclamation);		
		}
		return reclamations;
	}

	@Override
	public Reclamations addReclamation(Reclamations r) {
		return this.reclamationRepository.save(r);
	}

	@Override
	public void deleteReclamation(Long id) {
		this.reclamationRepository.deleteReclamationById(id);
	}

	@Override
	public void updateReclamation(Reclamations r) {
		 this.reclamationRepository.save(r);
	}

	@Override
	public Optional<Reclamations> retrieveReclamation(Long id) {
		return this.reclamationRepository.findById(id);
	}


}
