package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Endroit;

public interface EndroitService {
	public Endroit save(Endroit endroite);
	
List<Endroit> retrieveAllEndroit();
	
	
	
	
	
	void deleteEndroit(long id);
	
	Endroit updateEndroite(Endroit endroit);
	public List<Endroit> ListeEndroitR();
}
