package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Delivery;
import tn.esprit.spring.entities.DeliveryMan;
import tn.esprit.spring.repository.IDeliveryManRepository;

@Service

public class DeliveryManService implements IDeliveryManService{
	@Autowired
	IDeliveryManRepository iDeliveryManRepository ;

	@Override
	public List<DeliveryMan> retrieveAllDeliveryMan() {
		return (List<DeliveryMan>)iDeliveryManRepository.findAll();
	}

	@Override
	public void addDeliveryMan(DeliveryMan d) {
		iDeliveryManRepository.save(d);
		
	}

	@Override
	public void deleteDeliveryMan(Long id) {
		iDeliveryManRepository.deleteById(id);	
	}

	@Override
	public void updateDeliveryMan(DeliveryMan d) {
		iDeliveryManRepository.save(d);
		
	}

	@Override
	public Optional<DeliveryMan> retrieveDeliveryMan(Long id) {
		return iDeliveryManRepository.findById(id);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
