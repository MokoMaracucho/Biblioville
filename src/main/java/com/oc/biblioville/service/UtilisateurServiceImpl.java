package com.oc.biblioville.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oc.biblioville.entity.EmailUtilisateur;
import com.oc.biblioville.entity.Utilisateur;
import com.oc.biblioville.repository.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
    
    // ------------> GET
    
    // LISTE UTILISATEURS

    @Override
    @org.springframework.transaction.annotation.Transactional
    public List<Utilisateur> listeUtilisateurs() {
        return utilisateurRepository.findAll();
    }
    
    // UTILISATEUR BY ID

    @Override
    @org.springframework.transaction.annotation.Transactional
    public Utilisateur findByIdUtilisateur(Long idUtilisateur) {
        Utilisateur utilisateur = utilisateurRepository.findByIdUtilisateur(idUtilisateur);
        return utilisateur;
    }
    
    // ------------> POST
    
    // NOUVEL UTILISATEUR

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void addNewUtilisateur(Utilisateur utilisateur) {
//        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findByEmailUtilisateur(utilisateur.getEmailUtilisateur());
//        if(utilisateurOptional.isPresent()) {
//            throw new IllegalStateException("Cet email est déjà utilisé");
//        }
        utilisateurRepository.save(utilisateur);
    }
    
    // ------------> DELETE

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void deleteUtilisateur(Long idUtilisateur) {
        boolean existsIdUtilisateur = utilisateurRepository.existsById(idUtilisateur);
        if(!existsIdUtilisateur) {
            throw new IllegalStateException("L'utilisateur avec l'ID : " + idUtilisateur + " n'existe pas...");
        }
        utilisateurRepository.deleteById(idUtilisateur);
    }
    
    // ------------> PUT

    @Override
    @org.springframework.transaction.annotation.Transactional
    @Transactional
    public void updateUtilisateur(Long idUtilisateur, String email_utilisateur, String motPasseUtilisateur) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setIdUtilisateur(idUtilisateur);
        utilisateur.setEmailUtilisateur(email_utilisateur);
        utilisateur.setMotPasseUtilisateur(motPasseUtilisateur);;
//        		utilisateurRepository.findById(idUtilisateur).orElseThrow(() -> new IllegalStateException("L'utilisateur avec l'ID : " + idUtilisateur + " n'existe pas..."));
//        if(emailUtilisateur != null && emailUtilisateur.length() > 0 && !Objects.equals(utilisateur.getEmailUtilisateur(), emailUtilisateur)) {
//            Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findByEmailUtilisateur(emailUtilisateur);
//            if(optionalUtilisateur.isPresent()) {
//                throw new IllegalStateException("Cet email est déjà utilisé");
//            }
//            utilisateur.setEmailUtilisateur(emailUtilisateur);
//        }
        if(email_utilisateur != null && email_utilisateur.length() > 0) {
            utilisateur.setEmailUtilisateur(email_utilisateur);
        }
//        if(motPasseUtilisateur != null && motPasseUtilisateur.length() > 0 && !Objects.equals(utilisateur.getMotPasseUtilisateur(), motPasseUtilisateur)) {
//            utilisateur.setMotPasseUtilisateur(motPasseUtilisateur);
//        }
        if(motPasseUtilisateur != null && motPasseUtilisateur.length() > 0) {
            utilisateur.setMotPasseUtilisateur(motPasseUtilisateur);
        }
        utilisateurRepository.saveAndFlush(utilisateur);
    }

	@Override
	public void putUtilisateur(Utilisateur utilisateur, Long id_utilisateur) {
    	utilisateurRepository.save(utilisateur);
	}

	@Override
	public void patchUtilisateur(EmailUtilisateur emailUtilisateur, Long id_utilisateur) {
    	utilisateurRepository.save(emailUtilisateur);
	}
}
