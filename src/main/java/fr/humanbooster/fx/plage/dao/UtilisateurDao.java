package fr.humanbooster.fx.plage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.fx.plage.business.Utilisateur;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {

	boolean existsByEmail(String email);

	Utilisateur findLastByEmailAndMotDePasse(String email, String motDePasse);
}
