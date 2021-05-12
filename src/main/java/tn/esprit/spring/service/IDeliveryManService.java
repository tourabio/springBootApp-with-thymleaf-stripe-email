package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.DeliveryMan;


public interface IDeliveryManService {
	List<DeliveryMan> retrieveAllDeliveryMan();
	void addDeliveryMan(DeliveryMan d);
	void deleteDeliveryMan(Long id);
	void updateDeliveryMan(DeliveryMan d);
	Optional<DeliveryMan> retrieveDeliveryMan(Long id);	
}
