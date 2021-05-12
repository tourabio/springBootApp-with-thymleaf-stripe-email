package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Ray;


public interface RayService {
	public Ray save(Ray ray);
	List<Ray> retrieveAllRay();
	void deleteRay(long id);
	Ray updateRay(Ray ray);
	
}
