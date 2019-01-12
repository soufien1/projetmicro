package com.enrico.microservices.got.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "b3")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class B3 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
private Long id;

private String tribunaux;
@Temporal(TemporalType.DATE)
private Date datecond;
private String naturepeines;
private String natureinfra;
private String description;

@OneToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "citoyens_cin", nullable = false)
private Citoyens citoyens;

	public Citoyens getCitoyens() {
	return citoyens;
}
public void setCitoyens(Citoyens citoyens) {
	this.citoyens = citoyens;
}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTribunaux() {
		return tribunaux;
	}
	public void setTribunaux(String tribunaux) {
		this.tribunaux = tribunaux;
	}
	public Date getDatecond() {
		return datecond;
	}
	public void setDatecond(Date datecond) {
		this.datecond = datecond;
	}
	public String getNaturepeines() {
		return naturepeines;
	}
	public void setNaturepeines(String naturepeines) {
		this.naturepeines = naturepeines;
	}
	public String getNatureinfra() {
		return natureinfra;
	}
	public void setNatureinfra(String natureinfra) {
		this.natureinfra = natureinfra;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public B3() {
		super();
		// TODO Auto-generated constructor stub
	}
	public B3(String tribunaux, Date datecond, String naturepeines, String natureinfra, String description) {
		super();
		this.tribunaux = tribunaux;
		this.datecond = datecond;
		this.naturepeines = naturepeines;
		this.natureinfra = natureinfra;
		this.description = description;
	}
	
}