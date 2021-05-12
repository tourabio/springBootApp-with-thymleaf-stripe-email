package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Panier implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idpay;
	@Temporal (TemporalType.DATE)
	private Date datepayment;
	@Enumerated(EnumType.STRING)
	private Typepayment Typepayment;
	//@JsonIgnore
	@OneToOne(mappedBy="panier")
	private Facture facture;
	public Panier() {
		
	}

public long getIdpay() {
		return idpay;
	}
public void setIdpay(long idpay) {
		this.idpay = idpay;
	}



	public Date getDatepayment() {
		return datepayment;
	}
	public void setDatepayment(Date datepayment) {
		this.datepayment = datepayment;
	}
	public Typepayment getTypepayment() {
		return Typepayment;
	}
	public void setTypepayment(Typepayment typepayment) {
		Typepayment = typepayment;
	}

	
}
