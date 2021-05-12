package tn.esprit.spring.service;

import java.util.Optional;

import tn.esprit.spring.entities.Client;


public interface ClientService {
	Optional<Client> retrieveClient(Long id);	

}
