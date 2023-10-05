package fr.humanbooster.fx.plage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.fx.plage.business.Parasol;
import fr.humanbooster.fx.plage.business.Reservation;
import fr.humanbooster.fx.plage.service.ClientService;
import fr.humanbooster.fx.plage.service.ParasolService;
import fr.humanbooster.fx.plage.service.ReservationService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@SessionAttributes("reservation")
public class ReservationController {

	private final ReservationService reservationService;
	private final ParasolService parasolService;
	private final ClientService clientService;
	
	@GetMapping({"/reservations"})
	public ModelAndView getReservations(@PageableDefault(size=10, sort="dateDebut", direction = Direction.DESC) Pageable pageable) {
		ModelAndView mav = new ModelAndView();
		// La vue reservations.jsp va être utilisée pour produire le flux HTML qui est renvoyé au navigateur
		mav.setViewName("reservations");
		mav.addObject("pageDeReservations", reservationService.recupererReservations(pageable));
		String attributDeTri = pageable.getSort().iterator().next().getProperty();
		String directionDeTri = pageable.getSort().iterator().next().getDirection().name();
		System.out.println(pageable.getSort());
		mav.addObject("sort", attributDeTri + "," + directionDeTri);
		return mav;
	}
	
	@GetMapping(value = { "/reservation"})
	public ModelAndView getReservation(
			@RequestParam(name="ID_CLIENT", required=false) Long idClient,
			@RequestParam(name="ID_RESERVATION", required=false) Long idReservation,
			@RequestParam(name="NB_PARASOLS", required=false) Integer nbParasols) {
		ModelAndView mav = new ModelAndView("reservation");
		Reservation reservation = null;
		
		if (idReservation!=null) {
			reservation = reservationService.recupererReservation(idReservation);
		}
		else {
			reservation = new Reservation();
			if (idClient!=null) {
				reservation.setClient(clientService.recupererClient(idClient));
			}
			if (nbParasols!=null) {
				List<Parasol> parasols = new ArrayList<>();
				for (int i = 0; i < nbParasols; i++) {
					parasols.add(parasolService.recupererParasol(1L));					
				}
				reservation.setParasols(parasols);
			}
		}
		mav.addObject("reservation", reservation);
		mav.addObject("parasols", parasolService.recupererParasolsVirtuels());
		return mav;
	}
	
	@PostMapping("reservation")
	public ModelAndView postReservation(@Valid @ModelAttribute Reservation reservation, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView mav = getReservation(reservation.getId(), reservation.getClient().getId(), reservation.getParasols().size());
			mav.addObject("reservation", reservation);
			return mav;
		}
		reservationService.enregistrerReservation(reservation);
		return new ModelAndView("redirect:/reservations");
	}
}