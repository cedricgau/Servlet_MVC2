package count;

import java.util.Date;

public class RdvFormBean {
	private Date dateDemande= new Date();
	private String nom="";
	private String prenom="";
	private String numcompte="";
	private String montant="";
	
	public RdvFormBean() {
		// TODO Auto-generated constructor stub
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumcompte() {
		return numcompte;
	}

	public void setNumcompte(String numcompte) {
		this.numcompte = numcompte;
	}

	public String getMontant() {
		return montant;
	}

	public void setMontant(String string) {
		this.montant = string;
	}
	
	
	

}
