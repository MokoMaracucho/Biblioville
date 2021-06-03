package com.oc.biblioville.entity;

public class EmailUtilisateur {

    private Long idUtilisateur;
    private String emailUtilisateur;
    
	public EmailUtilisateur() {}
    
	public EmailUtilisateur(Long idUtilisateur, String emailUtilisateur) {
		this.idUtilisateur = idUtilisateur;
		this.emailUtilisateur = emailUtilisateur;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getEmailUtilisateur() {
		return emailUtilisateur;
	}

	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}

	@Override
	public String toString() {
		return "EmailUtilisateur [idUtilisateur=" + idUtilisateur + ", emailUtilisateur=" + emailUtilisateur + "]";
	}
}
