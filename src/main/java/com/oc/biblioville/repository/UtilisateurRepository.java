package com.oc.biblioville.repository;

import com.oc.biblioville.entity.Utilisateur;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    @Query("SELECT u FROM Utilisateur u WHERE u.emailUtilisateur = ?1")
    Optional<Utilisateur> findByEmailUtilisateur(String emailUtilisateur);

    @Query("SELECT u FROM Utilisateur u WHERE u.idUtilisateur = ?1")
    Optional<Utilisateur> findByIdUtilisateur(Long idUtilisateur);
}
