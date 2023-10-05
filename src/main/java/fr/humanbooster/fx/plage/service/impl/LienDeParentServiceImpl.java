package fr.humanbooster.fx.plage.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.fx.plage.business.LienDeParente;
import fr.humanbooster.fx.plage.dao.LienDeParenteDao;
import fr.humanbooster.fx.plage.service.LienDeParenteService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LienDeParentServiceImpl implements LienDeParenteService {

	private LienDeParenteDao lienDeParenteDao;
	
	@Override
	public List<LienDeParente> recupererLiensDeParente() {
		return lienDeParenteDao.findAll();
	}

	@Override
	public LienDeParente recupererLienDeParente(Long id) {
		return lienDeParenteDao.findById(id).orElse(null);
	}

}
