package fr.humanbooster.fx.plage.service;

import java.util.List;

import fr.humanbooster.fx.plage.business.LienDeParente;

public interface LienDeParenteService {

	List<LienDeParente> recupererLiensDeParente();

	LienDeParente recupererLienDeParente(Long id);

}