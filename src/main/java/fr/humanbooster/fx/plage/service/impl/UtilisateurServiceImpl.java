package fr.humanbooster.fx.plage.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.humanbooster.fx.plage.business.Utilisateur;
import fr.humanbooster.fx.plage.dao.UtilisateurDao;
import fr.humanbooster.fx.plage.service.UtilisateurService;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

	private final UtilisateurDao utilisateurDao;
	
	@Override
	@Transactional(readOnly=true)
	public Utilisateur recupererUtilisateur(String email, String motDePasse) {
		return utilisateurDao.findLastByEmailAndMotDePasse(email, motDePasse);
	}


}
