package fr.humanbooster.fx.plage.initialisation;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import fr.humanbooster.fx.plage.business.Client;
import fr.humanbooster.fx.plage.business.Concessionnaire;
import fr.humanbooster.fx.plage.business.File;
import fr.humanbooster.fx.plage.business.LienDeParente;
import fr.humanbooster.fx.plage.business.Parasol;
import fr.humanbooster.fx.plage.business.Pays;
import fr.humanbooster.fx.plage.business.Statut;
import fr.humanbooster.fx.plage.dao.ClientDao;
import fr.humanbooster.fx.plage.dao.ConcessionnaireDao;
import fr.humanbooster.fx.plage.dao.FileDao;
import fr.humanbooster.fx.plage.dao.LienDeParenteDao;
import fr.humanbooster.fx.plage.dao.ParasolDao;
import fr.humanbooster.fx.plage.dao.PaysDao;
import fr.humanbooster.fx.plage.dao.StatutDao;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@AllArgsConstructor
@Log4j2
public class AjoutDonneesInitiales implements CommandLineRunner {

	private final FileDao fileDao;
	private final ParasolDao parasolDao;
	private final PaysDao paysDao;	
	private final LienDeParenteDao lienDeParenteDao;
	private final ClientDao clientDao;
	private final ConcessionnaireDao concessionnaireDao;
	private final StatutDao statutDao;
	
	private static Random random = new Random();
	
	private static Faker faker = new Faker(Locale.FRENCH);

	@Override
	public void run(String... args) throws Exception {
		ajouterFiles();
		ajouterParasols();
		ajouterPays();
		ajouterLiensDeParente();
		ajouterClients(1000);
		ajouterConcessionnaire();
		ajouterStatuts();
		
		afficherStatistiques();
	}
	
	private void ajouterStatuts() {
		if (statutDao.count()==0) {
			statutDao.saveAll(Arrays.asList(new Statut("en attente de traitement"),
					new Statut("acceptée"), new Statut("refusée")));			
		}
    }
	
	private void ajouterFiles() {
		// On teste si des files sont déjà en base
		if (fileDao.count()==0) {
			// il n'y a pas encore de files en base, on ajoute 8 files
			double prixJournalier = 20;
			for (byte i = 1; i <=8; i++) {
				fileDao.save(new File(i, prixJournalier));
				prixJournalier -= 2;
			}
		}
	}

	private void ajouterParasols() {
		if (parasolDao.count()==0) {
			List<File> files = fileDao.findAll();
			for (File file : files) {
				for (byte i = 0; i <=7; i++) {
					parasolDao.save(new Parasol(i, file));					
				}
			}
		}	
	}

	private void ajouterPays() {
		if (paysDao.count() == 0) {
			paysDao.saveAll(Arrays.asList(new Pays("FR", "France"), new Pays("IT", "Italie"), new Pays("GB", "Royaume-Uni"), new Pays("PT", "Portugal")));
		}
	}
	
	private void ajouterLiensDeParente() {
		if (lienDeParenteDao.count()==0) {
			lienDeParenteDao.save(new LienDeParente("Frère/Soeur", 0.5f));
			lienDeParenteDao.save(new LienDeParente("Cousin/Cousine", 0.75f));
			lienDeParenteDao.save(new LienDeParente("Aucun", 1f));
		}
	}
	
	private void ajouterClients(int nbClientsAAjouter) {
		if (clientDao.count() == 0) {
			
			// Partie déclarative
			List<Pays> pays = paysDao.findAll();
			LienDeParente lienDeParenteAucun = lienDeParenteDao.findByNom("Aucun");
			Map<String, Client> map = new HashMap<>();
			int compteur = 0;
			Calendar calendar = Calendar.getInstance();

			// Partie traitement
			log.info("Ajout de " + nbClientsAAjouter + " clients");
			while (map.size() != nbClientsAAjouter) {
				compteur++;
				calendar.set(2020, 1, 1);
				Date dateDebut = calendar.getTime();
				calendar = Calendar.getInstance();
				Date dateFin = calendar.getTime();
				Date dateAleatoire = faker.date().between(dateDebut, dateFin);
				calendar.setTime(dateAleatoire);
				LocalDateTime dateHeureInscription = dateAleatoire.toInstant().atZone(ZoneId.systemDefault())
						.toLocalDateTime();
				//client.setDateHeureInscription(dateHeureInscription);
				Client client = new Client(dateHeureInscription);
				
				client.setNom(faker.name().lastName());
				client.setPrenom(faker.name().firstName());
				client.setPays(pays.get(random.nextInt(pays.size())));
				client.setEmail(faker.internet().emailAddress());
				
				client.setMotDePasse(String.valueOf(random.nextInt(99999999) + 10000000));
				client.setLienDeParente(lienDeParenteAucun);
				map.put(client.getEmail(), client);
			}
			clientDao.saveAll(map.values());
			log.info("nb de clients ajoutés:" + compteur);
			
		}
		
	}
	
	private void ajouterConcessionnaire() {
		if (concessionnaireDao.count() == 0) {
			Concessionnaire concessionnaire = new Concessionnaire();
			concessionnaire.setNom("ROSSI");
			concessionnaire.setPrenom("Giuseppe");
			concessionnaire.setEmail("peppe@humanbooster.fr");
			concessionnaire.setMotDePasse("12345678");
			concessionnaire.setNumeroDeTelephone(faker.phoneNumber().cellPhone());
			concessionnaireDao.save(concessionnaire);
		}	
	}
	
	private void afficherStatistiques() {

		clientDao.findSpanishCustomers().forEach(System.out::println);
		
		clientDao.findCustomersHavingNameStartingWithA().forEach(System.out::println);
		
		clientDao.findByPays(paysDao.findAll().get(0)).forEach(System.out::println);
		
		clientDao.findNbInscrits().forEach(System.out::println);
		
		clientDao.findClientsHavingFirstNameAlexisAndLivingInFrance().forEach(System.out::println);
		
		clientDao.findClientsWhoRegisteredIn2023().forEach(System.out::println);
				
		clientDao.findClientsWhoRegisteredBetween(LocalDateTime.of(2023, 2, 1, 0, 0), LocalDateTime.now())
			.forEach(c -> System.out.println(c.getNom().toUpperCase() + " " + c.getPrenom() + ", inscription le " + c.getDateHeureInscription()));
		
		clientDao.findNbInscrits().forEach(System.out::println);
		
		clientDao.findClientsWhoRegisteredToday().forEach(System.out::println);
		
		paysDao.findAllShuffled().forEach(System.out::println);
		
		paysDao.findCountriesWithoutCustomers().forEach(System.out::println);
		
		paysDao.findCountriesOrderedByNbOfCustomersDesc().forEach(System.out::println);

		File deuxiemeFile = fileDao.findAll().get(1);
		parasolDao.findByFile(deuxiemeFile).forEach(System.out::println);

	}

}