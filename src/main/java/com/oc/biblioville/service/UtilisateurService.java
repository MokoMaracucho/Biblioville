package com.oc.biblioville.service;

import java.util.List;

import com.oc.biblioville.entity.EmailUtilisateur;
import com.oc.biblioville.entity.Utilisateur;

public interface UtilisateurService {

    public List<Utilisateur> listeUtilisateurs();
    
    public Utilisateur findByIdUtilisateur(Long IdUtilisateur);

    public void addNewUtilisateur(Utilisateur utilisateur);

    public void deleteUtilisateur(Long idUtilisateur);

    public void updateUtilisateur(Long idUtilisateur, String emailUtilisateur, String motPasseUtilisateur);

	public void putUtilisateur(Utilisateur utilisateur, Long id_utilisateur);

	public void patchUtilisateur(EmailUtilisateur emailUtilisateur, Long id_utilisateur);
}
