package fr.humanbooster.fx.plage.service;

import fr.humanbooster.fx.plage.business.Utilisateur;

public interface UtilisateurService {

	Utilisateur recupererUtilisateur(String email, String motDePasse);
}
