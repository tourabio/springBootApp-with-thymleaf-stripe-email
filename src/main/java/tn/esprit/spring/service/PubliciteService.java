package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entities.Publicite;

public interface PubliciteService {
	public Publicite save(Publicite publicite);
	List<Publicite> retrieveAllPublicite();
	void deletePublicite(long id);
	Publicite updatePublicite(Publicite publicite);
}
