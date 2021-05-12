package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Panier;
import tn.esprit.spring.repository.PanierRepository;

@Service
public class PanierServiceImpl implements PanierService{
	@Autowired
	PanierRepository Pn;
	private static final Logger L =  LogManager.getLogger(BillServiceImpl.class);
	@Override
	public Panier savepan(Panier panier) {
		// TODO Auto-generated method stub
		return Pn.save(panier);
	}
	
@Override
		public List<Panier> getPanier(){
		List<Panier> Pan = (List<Panier>) Pn.findAll();
		for (Panier Panier: Pan){
		L.info("Panier +++: " + Pan);}
		return Pan;

	}
}
