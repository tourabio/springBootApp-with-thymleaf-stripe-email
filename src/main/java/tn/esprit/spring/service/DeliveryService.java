package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Delivery;
import tn.esprit.spring.repository.IDeliveryRepository;


@Service
public class DeliveryService implements IDeliveryService{
	
	private static final Logger L = LogManager.getLogger(DeliveryService.class);
	
	@Autowired
	IDeliveryRepository iDeliveryRepository;

	@Override
	public List<Delivery> getAllDeliveries() {
		List<Delivery> deliveries = (List<Delivery>) iDeliveryRepository.findAll();
		
		for(Delivery delivery:deliveries){
			L.info("users +++:"+delivery);
		}
		return deliveries;
	}

	@Override
	public Delivery addDelivery(Delivery d) {
		return iDeliveryRepository.save(d);

	}

	@Override
	public void deleteDelivery(String id) {
		iDeliveryRepository.deleteDeliveryById(Long.parseLong(id));	
	}

	/*@Override
	public Delivery updateDelivery(Delivery u) {
		Delivery userToUpdate = iDeliveryRepository.findById(u.getId()).get(); 
		userToUpdate.setDateDebut(u.getDateDebut());
		userToUpdate.setFirstName(u.getFirstName());
		userToUpdate.setLastName(u.getLastName());
		userToUpdate.setRole(u.getRole());
		return iDeliveryRepository.save(userToUpdate);
	}*/

	@Override
	public Delivery getDelivery(String id) {
		Delivery deliveryToReturn = iDeliveryRepository.findById(Long.parseLong(id)).get(); 
		L.info("users +++:"+deliveryToReturn);

		return deliveryToReturn;
	}

}
