package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "VisiteV_Virtuelle")

public class VisiteVirtuelleEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VisiteVirtuelle_ID")
	private Long id;
	@Temporal(TemporalType.DATE)
	Date postDate;

	private Integer rating;

	private String view;


	private String url;


	private String rayon;


	private String etage;






	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}




	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getrayon() {
		return rayon;
	}

	public void setrayon(String rayon) {
		this.rayon = rayon;
	}

	public String getetage() {
		return etage;
	}

	public void setetage(String etage) {
		this.etage = etage;
	}




	@Override
	public String toString() {
		return "VisiteVirtuelleEntity [id=" + id + ", postDate=" + postDate + ", rating=" + rating + ", view=" + view
				+ ", url=" + url + ", rayon=" + rayon + ", etage=" + etage  + "]";
	}



	public VisiteVirtuelleEntity(Long id, Date postDate, Integer rating, String view, String url, String rayon, String etage) {
		super();
		this.id = id;
		this.postDate = postDate;
		this.rating = rating;
		this.view = view;
		this.url = url;
		this.rayon = rayon;
		this.etage = etage;

	}
	public VisiteVirtuelleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}