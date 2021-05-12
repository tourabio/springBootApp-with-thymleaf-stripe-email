package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity

public class DeliveryMan extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	private float salary;
	private float prime;
	private double longitude ;
	private double latitude ;
	private boolean disponible;
	
	
	
	
	public DeliveryMan() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	public DeliveryMan(float salary, float prime, double longitude, double latitude, boolean disponible, City lieu,
			Set<Delivery> deliveries) {
		super();
		this.salary = salary;
		this.prime = prime;
		this.longitude = longitude;
		this.latitude = latitude;
		this.disponible = disponible;
		this.lieu = lieu;
		this.deliveries = deliveries;
	}






	@Enumerated(EnumType.STRING)
	private City lieu;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="deliveryMans",fetch = FetchType.EAGER)
	private Set<Delivery> deliveries;


	public Set<Delivery> getDeliveries() {
		return deliveries;
	}


	public void setDeliveries(Set<Delivery> deliveries) {
		this.deliveries = deliveries;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public float getSalary() {
		return salary;
	}


	public void setSalary(float salary) {
		this.salary = salary;
	}


	public float getPrime() {
		return prime;
	}


	public void setPrime(float prime) {
		this.prime = prime;
	}
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	public City getLieu() {
		return lieu;
	}


	public void setLieu(City lieu) {
		this.lieu = lieu;
	}
	
	
	
	
	
	
	
	
	
}
