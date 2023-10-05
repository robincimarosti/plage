package fr.humanbooster.fx.plage.service;

import java.util.List;

import fr.humanbooster.fx.plage.business.Pays;
import fr.humanbooster.fx.plage.dto.PaysDto;

public interface PaysService {

	List<Pays> recupererPays();

	Pays ajouterPays(String code, String nom);

	Pays mettreAJour(String code, String nouveauNom);

	Pays recupererPays(String code);

	Pays enregistrerPays(Pays pays);

	boolean supprimerPays(String code);

	Pays enregistrerPays(PaysDto paysDto);

}