package fr.humanbooster.fx.plage.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.fx.plage.business.Client;
import fr.humanbooster.fx.plage.business.Reservation;
import fr.humanbooster.fx.plage.business.Statut;

public interface ReservationDao extends JpaRepository<Reservation, Long> {

	List<Reservation> findByDateDebutBetween(LocalDate dateHeure, LocalDate dateFin);
	
	List<Reservation> findByMontantAReglerEnEurosGreaterThanAndDateDebutBetween(double seuil, LocalDate dateDebut, LocalDate dateFin);
	
	List<Reservation> findByClient(Client client);
	
	// Réservations pas encore associées à un concessionnaire
	List<Reservation> findByConcessionnaireIsNull();

	Page<Reservation> findByStatut(Pageable pageable, Statut statut);
	
}