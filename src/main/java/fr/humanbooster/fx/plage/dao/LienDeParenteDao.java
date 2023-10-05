package fr.humanbooster.fx.plage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.fx.plage.business.LienDeParente;

public interface LienDeParenteDao extends JpaRepository<LienDeParente, Long> {

	// Query-method
	// Requête par dérivation
	LienDeParente findByNom(String nom);

}
