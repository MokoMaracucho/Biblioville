package com.oc.biblioville.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oc.biblioville.entity.Utilisateur;
import com.oc.biblioville.repository.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void addNewUtilisateur(Utilisateur utilisateur) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository
                .findUtilisateurByEmail(utilisateur.getEmailUtilisateur());
        if(utilisateurOptional.isPresent()) {
            throw new IllegalStateException("Cet email est déjà utilisé");
        }
        utilisateurRepository.save(utilisateur);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void deleteUtilisateur(Long idUtilisateur) {
        boolean existsIdUtilisateur = utilisateurRepository.existsById(idUtilisateur);
        if(!existsIdUtilisateur) {
            throw new IllegalStateException("L'utilisateur avec l'ID : " + idUtilisateur + " n'existe pas...");
        }
        utilisateurRepository.deleteById(idUtilisateur);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    @Transactional
    public void updateUtilisateur(Long idUtilisateur, String emailUtilisateur, String motPasseUtilisateur) {
        Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur).orElseThrow(() -> new IllegalStateException("L'utilisateur avec l'ID : " + idUtilisateur + " n'existe pas..."));
        if(emailUtilisateur != null && emailUtilisateur.length() > 0 && !Objects.equals(utilisateur.getEmailUtilisateur(), emailUtilisateur)) {
            Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findUtilisateurByEmail(emailUtilisateur);
            if(optionalUtilisateur.isPresent()) {
                throw new IllegalStateException("Cet email est déjà utilisé");
            }
            utilisateur.setEmailUtilisateur(emailUtilisateur);
        }
        if(motPasseUtilisateur != null && motPasseUtilisateur.length() > 0 && !Objects.equals(utilisateur.getMotPasseUtilisateur(), motPasseUtilisateur)) {
            utilisateur.setMotPasseUtilisateur(motPasseUtilisateur);
        }
    }
}
