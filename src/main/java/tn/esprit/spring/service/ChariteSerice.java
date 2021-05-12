package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Charite;

public interface ChariteSerice {
	public Charite save(Charite charite);

	List<Charite> retrieveAllCharite();
	
	
	//

	
	void deleteCharite(long id);
	
	Charite updateCharite(Charite charit);

	public float TotalDonation();
	
	
	
	
	
	
	
	
}
