package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Event implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String eventname;
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endsdate;
	@PrePersist
	private void onCrete() 
	{
		startdate = new Date();
	}
	@OneToOne
	@JsonIgnore
	private Publicite publicite;

	public Publicite getPublicite() {
		return publicite;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "eventss")
	private Set<Endroit> endroit;
	public void setPublicite(Publicite publicite) {
		this.publicite = publicite;
	}
	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE},fetch=FetchType.EAGER,mappedBy = "event")
	public Set<Charite> charite;

	public Set<Charite> getCharite() {
		return charite;
	}

	public void setCharite(Set<Charite> charite) {
		this.charite = charite;
	}

	public Set<Endroit> getEndroit() {
		return endroit;
	}

	public void setEndroit(Set<Endroit> endroit) {
		this.endroit = endroit;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEndsdate() {
		return endsdate;
	}

	public void setEndsdate(Date endsdate) {
		this.endsdate = endsdate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Event() {
		
	}
	
}
