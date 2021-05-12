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
import tn.esprit.spring.repository.ChariteRepository;

@Service
public class ChariteServiceImpl implements ChariteSerice{
@Autowired
ChariteRepository cr;
private static final Logger L =  LogManager.getLogger(EventServiceImpl.class);
@Override
public Charite save(Charite charite) {
	// TODO Auto-generated method stub
	return cr.save(charite);
}
@Override
public List<Charite> retrieveAllCharite() {
	// TODO Auto-generated method stub
	List<Charite> charites = (List<Charite>) cr.findAll();
	for (Charite charite : charites){
	L.info("charite +++: " + charite );}
	return charites;
}
@Override
public void deleteCharite(long id) {
	// TODO Auto-generated method stub
Optional<Charite> charite = cr.findById(id);
    
    if(charite.isPresent()) 
    {
        cr.deleteById(id);}	
}
/*@Override
public Charite updateCharite(Charite charit) {
	// TODO Auto-generated method stub
	Optional<Charite> charite = cr.findById(charit.getId());
	if(charite.isPresent()) 
    {
	     Charite newCharite = charite.get();
        newCharite.setMontantpaye(charit.getMontantpaye());
        newCharite.setTypecharite(charit.getTypecharite());
     
       
         
        return newCharite;
    } else {
        charit = cr.save(charit);
         
        return charit;
    }
}
	*/
@Override
public Charite updateCharite(Charite charit) {
	// TODO Auto-generated method stub
	return cr.save(charit);
}
public float TotalDonation() {
	return cr.TotalDonation();
}
}





