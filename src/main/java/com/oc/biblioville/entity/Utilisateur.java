package com.oc.biblioville.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_utilisateurs")
public class Utilisateur {

    @Id
    @SequenceGenerator(
            name ="utilisateur_sequence",
            sequenceName = "utilisateur_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "utilisateur_sequence"
    )
	@Column(name="id_utilisateur", updatable=false)
    private Long idUtilisateur;
	@Column(name="email_utilisateur")
    private String emailUtilisateur;
	@Column(name="mot_passe_utilisateur")
    private String motPasseUtilisateur;

    public Utilisateur() {
    }

    public Utilisateur(Long idUtilisateur, String emailUtilisateur, String motPasseUtilisateur) {
        this.idUtilisateur = idUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.motPasseUtilisateur = motPasseUtilisateur;
    }

    public Utilisateur(String emailUtilisateur, String motPasseUtilisateur) {
        this.emailUtilisateur = emailUtilisateur;
        this.motPasseUtilisateur = motPasseUtilisateur;
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

    public String getMotPasseUtilisateur() {
        return motPasseUtilisateur;
    }

    public void setMotPasseUtilisateur(String motPasseUtilisateur) {
        this.motPasseUtilisateur = motPasseUtilisateur;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "idUtilisateur=" + idUtilisateur +
                ", emailUtilisateur='" + emailUtilisateur + '\'' +
                ", motPasseUtilisateur='" + motPasseUtilisateur + '\'' +
                '}';
    }
}
