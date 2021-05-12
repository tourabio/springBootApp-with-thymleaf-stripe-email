package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Charite;
import tn.esprit.spring.entities.Endroit;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.repository.EndroitRepository;

@Service
public class EndroitServiceImpl implements EndroitService {
@Autowired
EndroitRepository er;
private static final Logger L =  LogManager.getLogger(EventServiceImpl.class);
	@Override
	public Endroit save(Endroit endroite) {
		// TODO Auto-generated method stub
		return er.save(endroite);
	}

	@Override
	public List<Endroit> retrieveAllEndroit() {
		// TODO Auto-generated method stub
		List<Endroit> endroit = (List<Endroit>) er.findAll();
		for (Endroit endroite : endroit){
		L.info("endroite +++: " + endroite );}
		return endroit;
	}
	@Override
	public void deleteEndroit(long id) {
		// TODO Auto-generated method stub
		Optional<Endroit> endroit = er.findById(id);
	    
	    if(endroit.isPresent()) 
	    {
	        er.deleteById(id);}	
	}

	/*@Override
	public Endroit updateEndroite(Endroit endroit) {
		// TODO Auto-generated method stub
		Optional<Endroit> endroite = er.findById(endroit.getId());
		if(endroite.isPresent()) 
	    {
		     Endroit newEndroit = endroite.get();
	        newEndroit.setEmplacement(endroit.getEmplacement());
	        newEndroit.setId(endroit.getId());
	        newEndroit.setNbplace(endroit.getNbplace());
	       
	         
	        return newEndroit;
	    } else {
	        endroit = er.save(endroit);
	         
	        return endroit;
	    }}
*/
	@Override
	public Endroit updateEndroite(Endroit endroit) {
		// TODO Auto-generated method stub
		return er.save(endroit);
	}
	
	public List<Endroit> ListeEndroitR(){
		return er.ListeEndroitR();
	}
	



















}

