package fr.humanbooster.fx.plage.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.fx.plage.business.Utilisateur;
import fr.humanbooster.fx.plage.service.UtilisateurService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@AllArgsConstructor
@Log4j2
public class UtilisateurController {

	private final UtilisateurService utilisateurService;
	private final HttpSession httpSession;
	
	@GetMapping(value = { "/connexion"})
	public ModelAndView getConnexion() {		
		//System.out.println(new Date() + " dans getConnexion()");
		log.warn(new Date() + " dans getConnexion()");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");		
		return mav;
	}
	
	@PostMapping("/connexion")
	public ModelAndView postConnexion(@RequestParam("EMAIL") String email, @RequestParam("MOT_DE_PASSE") String motDePasse) {
		System.out.println(new Date() + " dans postConnexion()");
		Utilisateur utilisateur = utilisateurService.recupererUtilisateur(email, motDePasse);
		if (utilisateur==null) {
			ModelAndView mav = new ModelAndView("redirect:index");
			mav.addObject("notification", "Mot de passe et/ou email incorrect");
			return mav;
		}
		else {
			// On ajoute en session HTTP l'objet utilisateur
			httpSession.setAttribute("utilisateur", utilisateur);
			ModelAndView mav = new ModelAndView("redirect:clients");
			return mav;
		}
	}
	
	@GetMapping("deconnexion")
	public ModelAndView getDeconnexion() {
		httpSession.invalidate();
		ModelAndView mav = new ModelAndView("redirect:/index");
		mav.addObject("notification", "Au revoir");
		return mav;
	}
}
