package tn.esprit.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{
	@Autowired
	ClientRepository clientRepository;

	@Override
	public Optional<Client> retrieveClient(Long id) {
		return clientRepository.findById(id);
	}
	
}
