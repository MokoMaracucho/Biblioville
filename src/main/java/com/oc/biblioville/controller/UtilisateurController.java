package com.oc.biblioville.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(path="listeUtilisateurs")
    public List<Utilisateur> listeUtilisateurs() {
        return utilisateurService.listeUtilisateurs();
    }

    @GetMapping(path="{id_utilisateur}")
    public Utilisateur findByIdUtilisateur(@PathVariable("id_utilisateur") Long idUtilisateur) {
        return utilisateurService.findByIdUtilisateur(idUtilisateur);
    }

    @PostMapping
    public void addNewUtilisateur(@RequestBody Utilisateur utilisateur) {
        utilisateurService.addNewUtilisateur(utilisateur);
    }

    @DeleteMapping(path="{id_utilisateur}")
    public void deleteUtilisateur(@PathVariable("id_utilisateur") Long idUtilisateur) {
        utilisateurService.deleteUtilisateur(idUtilisateur);
    }

    @PutMapping(path="{id_utilisateur}")
    public void updateUtilisateur(
            @PathVariable("idUtilisateur") Long idUtilisateur,
            @RequestParam(required=false) String emailUtilisateur,
            @RequestParam(required=false) String MotPasseUtilisateur) {
        utilisateurService.updateUtilisateur(idUtilisateur, emailUtilisateur, MotPasseUtilisateur);
    }
}
