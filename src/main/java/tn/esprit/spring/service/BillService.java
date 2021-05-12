package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Typepayment;



public interface BillService {
	public Facture save(Facture facture);

	List<Facture> getAllBill();

	public Facture updateBill(Facture fr);

	void deleteBill(Long id);

	Optional<Facture> getBill_by_ID(Long id);

	void modify_type_bill(Typepayment paymentType, Long id);

	String get_payment_type_by_id(Long id);

	void billpdf(Long id);

	
}
