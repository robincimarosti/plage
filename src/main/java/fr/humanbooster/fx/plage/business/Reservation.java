package fr.humanbooster.fx.plage.business;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Entity
@Data
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	@Size(min=1)
	private List<Parasol> parasols;
	
	@ManyToOne
	@NotNull(message="Merci de préciser le client")
	private Client client;
	
	@DateTimeFormat(iso=ISO.DATE)
	@NotNull(message="Merci de préciser la date de début de la réservation")
	private LocalDate dateDebut;

	@DateTimeFormat(iso=ISO.DATE)
	@NotNull(message="Merci de préciser la date de fin de la réservation")
	private LocalDate dateFin;
	
	private double montantAReglerEnEuros;

	@Lob
	private String remarques;
	
	@ManyToOne
	private Statut statut;
	
	@ManyToOne
	private Concessionnaire concessionnaire;
	
	@CreditCardNumber
	private String numeroCarte;
	
	private byte moisExpiration;
	
	private short anneeExpiration;
	
	private String cryptogramme;
	
}