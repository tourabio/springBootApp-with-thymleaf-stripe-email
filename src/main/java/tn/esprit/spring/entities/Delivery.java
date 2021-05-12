package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@Entity
@Table(name = "T_DELIVERY")
public class Delivery implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DELIVERY_ID")
	private Long id; // Clé primaire

	@Temporal(TemporalType.DATE)
	private Date deliveryDate;
	
	@Column(name = "DELIVERY_STATUS")
	private String status;

	@Transient
	private float frais;
	
	
	
	@ManyToOne
	DeliveryMan deliveryMans;
	
	
	
	@Enumerated(EnumType.STRING)
	private City lieu;
	
	@Enumerated(EnumType.STRING)
	private MoyenTransport moyenTransport;
	
	
	private double longitude ;
	private double latitude ;


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "delivery",fetch = FetchType.EAGER)
	private Set<Product> products;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public DeliveryMan getDeliveryMans() {
		return deliveryMans;
	}

	public void setDeliveryMans(DeliveryMan deliveryMans) {
		this.deliveryMans = deliveryMans;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


/*
	public Set<Order> getOrders() {
		return orders;
	}*/
/*
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", deliveryDate=" + deliveryDate + ", status=" + status
				 + ", deliveryMans=" + deliveryMans + ", orders=" + orders + "]";
	}
	*/
	public Delivery(Date deliveryDate, String status, DeliveryMan deliveryMans) {
		this.deliveryDate = deliveryDate;
		this.status = status;
		this.deliveryMans = deliveryMans;
	}

	public Delivery() {
	}

	public Delivery( Date deliveryDate, String status) {
		this.deliveryDate = deliveryDate;
		this.status = status;

	}

	public City getLieu() {
		return lieu;
	}

	public void setLieu(City lieu) {
		this.lieu = lieu;
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

	public MoyenTransport getMoyenTransport() {
		return moyenTransport;
	}

	public void setMoyenTransport(MoyenTransport moyenTransport) {
		this.moyenTransport = moyenTransport;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	
	
	
	public float getFrais() {
		return frais;
	}

	public void setFrais(float frais) {
		this.frais = frais;
	}

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", deliveryDate=" + deliveryDate + ", status=" + status + ", deliveryMans="
				+ deliveryMans + ", lieu=" + lieu + ", moyenTransport=" + moyenTransport + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", products=" + products + "]";
	}

	
	

	
	

}
