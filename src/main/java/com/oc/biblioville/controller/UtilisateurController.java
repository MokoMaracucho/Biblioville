package com.oc.biblioville.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oc.biblioville.entity.EmailUtilisateur;
import com.oc.biblioville.entity.Utilisateur;
import com.oc.biblioville.service.UtilisateurService;

@RestController
@RequestMapping(path="utilisateur")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
    
    // ------------> GET

    @GetMapping(path="listeUtilisateurs")
    public List<Utilisateur> listeUtilisateurs() {
        return utilisateurService.listeUtilisateurs();
    }

    @GetMapping(path="{id_utilisateur}")
    public Utilisateur findByIdUtilisateur(@PathVariable("id_utilisateur") Long idUtilisateur) {
        return utilisateurService.findByIdUtilisateur(idUtilisateur);
    }
    
    // ------------> POST

    @PostMapping
    public void addNewUtilisateur(@RequestBody Utilisateur utilisateur) {
        utilisateurService.addNewUtilisateur(utilisateur);
    }
    
    // ------------> DELETE

    @DeleteMapping(path="{id_utilisateur}")
    public void deleteUtilisateur(@PathVariable("id_utilisateur") Long idUtilisateur) {
        utilisateurService.deleteUtilisateur(idUtilisateur);
    }
    
    // ------------> PUT
    
    @PutMapping(path="/putUtilisateur/{id_utilisateur}")
	public void putUtilisateur(@RequestBody Utilisateur utilisateur, @PathVariable("id_utilisateur") Long id_utilisateur) {
    	utilisateur.setIdUtilisateur(id_utilisateur);
	    utilisateurService.putUtilisateur(utilisateur, id_utilisateur);
	}
    
    // ------------> PATCH

    @PatchMapping(path="/patchUtilisateur/{id_utilisateur}")
	public void patchUtilisateur(@RequestBody EmailUtilisateur emailUtilisateur, @PathVariable("id_utilisateur") Long id_utilisateur) {
//    	emailUtilisateur.setIdUtilisateur(id_utilisateur); 
	    utilisateurService.patchUtilisateur(emailUtilisateur, id_utilisateur);
	}
}
