package fr.humanbooster.fx.plage.automatisme;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailAutomate {

	//private ClientService clientService;
	
	@Scheduled(cron = "0 0 0 * * *")
	private void envoyerMails() {
		System.out.println("Envoi d'un mail");
	}
}
