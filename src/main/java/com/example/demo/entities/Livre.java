package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor 
@Table(name="Livre")

public class Livre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	
	private Long id;
	@Column(length = 50)
	@NonNull
	private String titre;
	@Column(updatable=false)
	@NonNull
	
	private String maisonEdition;
	@Column
	@NonNull
	private Date datesortie;
	@Column
	@NonNull
	private String auteur;
	@Column
	@NonNull
	private int nbrpages;
	@Column(unique=true,updatable=false)
	@NonNull
  
	private int ISBN;
	@Column
	@NonNull
	private Date dateconsultation;
	@Column
	@NonNull
	private boolean disponibilite;
	
	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", maisonEdition=" + maisonEdition + ", datesortie="
				+ datesortie + ", auteur=" + auteur + ", nbrpages=" + nbrpages + ", ISBN=" + ISBN
				+ ", dateconsultation=" + dateconsultation + ", disponibilite=" + disponibilite + "]";
	}
	public Livre(@NonNull Long id, @NonNull String titre, @NonNull String maisonEdition, @NonNull Date datesortie,
			@NonNull String auteur, @NonNull int nbrpages, @NonNull int iSBN, @NonNull Date dateconsultation,
			@NonNull boolean disponibilite) {
		super();
		this.id = id;
		this.titre = titre;
		this.maisonEdition = maisonEdition;
		this.datesortie = datesortie;
		this.auteur = auteur;
		this.nbrpages = nbrpages;
		ISBN = iSBN;
		this.dateconsultation = dateconsultation;
		this.disponibilite = disponibilite;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDatesortie() {
		return datesortie;
	}
	public void setDatesortie(Date datesortie) {
		this.datesortie = datesortie;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public int getNbrpages() {
		return nbrpages;
	}
	public void setNbrpages(int nbrpages) {
		this.nbrpages = nbrpages;
	}
	public Date getDateconsultation() {
		return dateconsultation;
	}
	public void setDateconsultation(Date dateconsultation) {
		this.dateconsultation = dateconsultation;
	}
	public boolean isDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}
	

	public Livre() {}

}
