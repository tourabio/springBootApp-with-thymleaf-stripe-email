package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Endroit;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Publicite;
import tn.esprit.spring.repository.PubliciteRepository;

@Service
public class PubliciteServiceImpl implements PubliciteService {
	@Autowired
	PubliciteRepository pr;
	private static final Logger L =  LogManager.getLogger(EventServiceImpl.class);
	@Override
	public Publicite save(Publicite publicite) {
		// TODO Auto-generated method stub
		return pr.save(publicite);
	}
	@Override
	public List<Publicite> retrieveAllPublicite() {
		// TODO Auto-generated method stub
		List<Publicite> publicite = (List<Publicite>) pr.findAll();
		for (Publicite pub : publicite){
		L.info("publicite +++: " + pub );}
		return publicite;

	}

	@Override
	public void deletePublicite(long id) {
		// TODO Auto-generated method stub
Optional<Publicite> publicite = pr.findById(id);
	    
	    if(publicite.isPresent()) 
	    {
	        pr.deleteById(id);}	
	
	}

	/*@Override
	public Publicite updatePublicite(Publicite publicite) {
		// TODO Auto-generated method stub
		Optional<Publicite> pub = pr.findById(publicite.getId());
		if(pub.isPresent()) 
	    {
		     Publicite newPublicite= pub.get();
		     newPublicite.setDatedebut(publicite.getDatedebut());
		     newPublicite.setDatefin(publicite.getDatefin());
		     newPublicite.setId(publicite.getId());
		     newPublicite.setImage(publicite.getImage());
		     newPublicite.setNom(publicite.getNom());
	        return newPublicite;
	    } else {
	    	publicite = pr.save(publicite);
	         
	        return publicite;
	    }}*/
	
	@Override
	public Publicite updatePublicite(Publicite publicite) {
		// TODO Auto-generated method stub
		return pr.save(publicite);

}}
