package com.enrico.microservices.got.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "cnam")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Remboursements implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String reference;
	private String typeMaladie;
	private String causeMaladie;
	@Temporal(TemporalType.DATE)
	private Date dateService;
	@Temporal(TemporalType.DATE)
	private Date dateDepot;
	private String montantDep;
	private String montantRemb;
	private String etat;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "citoyens_numaff", nullable = false)
    @JsonIgnore
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
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getTypeMaladie() {
		return typeMaladie;
	}
	public void setTypeMaladie(String typeMaladie) {
		this.typeMaladie = typeMaladie;
	}
	public String getCauseMaladie() {
		return causeMaladie;
	}
	public void setCauseMaladie(String causeMaladie) {
		this.causeMaladie = causeMaladie;
	}
	public Date getDateService() {
		return dateService;
	}
	public void setDateService(Date dateService) {
		this.dateService = dateService;
	}
	public Date getDateDepot() {
		return dateDepot;
	}
	public void setDateDepot(Date dateDepot) {
		this.dateDepot = dateDepot;
	}
	public String getMontantDep() {
		return montantDep;
	}
	public void setMontantDep(String montantDep) {
		this.montantDep = montantDep;
	}
	public String getMontantRemb() {
		return montantRemb;
	}
	public void setMontantRemb(String montantRemb) {
		this.montantRemb = montantRemb;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Remboursements() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Remboursements(String reference, String typeMaladie, String causeMaladie, Date dateService, Date dateDepot,
			String montantDep, String montantRemb, String etat) {
		super();
		this.reference = reference;
		this.typeMaladie = typeMaladie;
		this.causeMaladie = causeMaladie;
		this.dateService = dateService;
		this.dateDepot = dateDepot;
		this.montantDep = montantDep;
		this.montantRemb = montantRemb;
		this.etat = etat;
	}
	
}