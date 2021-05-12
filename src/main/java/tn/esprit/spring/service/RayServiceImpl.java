package tn.esprit.spring.service;


import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Ray;
import tn.esprit.spring.repository.RayRepository;


@Service
public class RayServiceImpl implements RayService{
	@Autowired
	RayRepository Rr;
	private static final Logger L =  LogManager.getLogger(RayServiceImpl.class);
	@Override
	public Ray save(Ray ray) {
		// TODO Auto-generated method stub
		return Rr.save(ray);
	}
	@Override
	public List<Ray> retrieveAllRay() {
		// TODO Auto-generated method stub
		List<Ray> rayon = (List<Ray>) Rr.findAll();
		for (Ray ray : rayon){
		L.info("ray +++: " + ray );}
		return rayon;
	}
	@Override
	public void deleteRay(long id) {
		// TODO Auto-generated method stub
		Optional<Ray> rayon = Rr.findById((int) id);
	    
	    if(rayon.isPresent()) 
	        Rr.deleteById((int) id);}	
	


	@Override
	public Ray updateRay(Ray ray) {
		// TODO Auto-generated method stub
		return Rr.save(ray);
	}

	}

